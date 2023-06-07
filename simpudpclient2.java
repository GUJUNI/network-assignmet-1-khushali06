
// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment 
// ===================================================================================
//  write simple UDP programme in java for check number divisible by 3 or not
// ===================================================================================

// ==>client-side programme


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

 class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost"); // Server IP address
            int serverPort = 1234; // Server port number

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            String numberStr = scanner.nextLine();

            byte[] sendData = numberStr.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String response = new String(receivePacket.getData()).trim();

            boolean isDivisibleByThree = Boolean.parseBoolean(response);

            if (isDivisibleByThree) {
                System.out.println(numberStr + " is divisible by 3.");
            } else {
                System.out.println(numberStr + " is not divisible by 3.");
            }

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


// ===================================================================================
// Output
// ===================================================================================

// 
/*
--server
java Server
Server started. Waiting for client...
Response sent to client.

--client:

 java Client
Enter a number: 18
18 is divisible by 3.
 */