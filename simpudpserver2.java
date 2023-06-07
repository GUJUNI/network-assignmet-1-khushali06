// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment 
// ===================================================================================
//write simple UDP programme in java for check number divisible by 3 or not
// ===================================================================================

// ==>server-side programme

import java.net.DatagramPacket;
import java.net.DatagramSocket;

 class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(1234); // Port number

            System.out.println("Server started. Waiting for client...");

            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String numberStr = new String(receivePacket.getData()).trim();
                int number = Integer.parseInt(numberStr);

                boolean isDivisibleByThree = number % 3 == 0;

                byte[] sendData = String.valueOf(isDivisibleByThree).getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                        receivePacket.getAddress(), receivePacket.getPort());

                serverSocket.send(sendPacket);

                System.out.println("Response sent to client.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
