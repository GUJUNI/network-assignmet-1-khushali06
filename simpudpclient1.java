// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment 
// ===================================================================================
// 1-b)simple UDP programme in java for print sum of each digit entered number by user.
// ===================================================================================

// ==>client-side programme

import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        System.out.print("Enter a number: ");
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String sumString = new String(receivePacket.getData());
        System.out.println("The sum of the digits is: " + sumString.trim());
        clientSocket.close();
    }
}

// ===================================================================================
// Output
// ===================================================================================

// --client:
// javac UDPClient.java
// java UDPClient

// Enter a number: 123456
// The sum of the digits is: 21
