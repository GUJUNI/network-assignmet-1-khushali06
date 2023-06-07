// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment 
// ===================================================================================
// write UDP Program in java with multithreaded server for print pyramid in which row  entered by user.
// ===================================================================================

// ==>server-side programme


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 class UDPServer {
    private static final int PORT = 12345;
    private static final int MAX_THREADS = 10;

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(PORT);
            System.out.println("Server started and listening on port " + PORT);

            ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Start a new thread to handle the client request
                ClientHandler clientHandler = new ClientHandler(serverSocket, receivePacket.getAddress(),
                        receivePacket.getPort(), clientMessage);
                executorService.execute(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private DatagramSocket serverSocket;
    private String clientMessage;
    private java.net.InetAddress clientAddress;
    private int clientPort;

    public ClientHandler(DatagramSocket serverSocket, java.net.InetAddress clientAddress, int clientPort,
            String clientMessage) {
        this.serverSocket = serverSocket;
        this.clientAddress = clientAddress;
        this.clientPort = clientPort;
        this.clientMessage = clientMessage;
    }

    @Override
    public void run() {
        try {
            int rows = Integer.parseInt(clientMessage);

            StringBuilder pyramid = new StringBuilder();

            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= rows - i; j++) {
                    pyramid.append(" ");
                }

                for (int k = 1; k <= i; k++) {
                    pyramid.append("* ");
                }

                pyramid.append("\n");
            }

            byte[] sendData = pyramid.toString().getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
