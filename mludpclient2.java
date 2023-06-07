// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment 
// ===================================================================================
// write UDP Program in java with multithreaded server for print pyramid in which row  entered by user.
// ===================================================================================

// ==>client-side programme


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPClient {
    private static final int PORT = 12345;
    private static final String SERVER_IP = "localhost";

    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            byte[] sendData;
            byte[] receiveData = new byte[1024];

            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

            // Read the number of rows from the user
            System.out.print("Enter the number of rows for the pyramid: ");
            String numRows = System.console().readLine();

            sendData = numRows.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, PORT);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server response:\n" + serverResponse);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



/*
 // ===================================================================================
// Output
// ===================================================================================

--server:

Server started and listening on port 12345

--client:

Enter the number of rows for the pyramid: 4
Server response:
   *
  * *
 * * *
* * * *

*/