// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment 
// ===================================================================================
// 1-a)simple UDP programme in java for print sum of each digit entered number by user.
// ===================================================================================

// ==>server-side programme

import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            int num = Integer.parseInt(sentence.trim());

            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            String sumString = Integer.toString(sum);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            sendData = sumString.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}

// ===================================================================================
// Output
// ===================================================================================

// --server:
// javac UDPServer.java
// java UDPServer
