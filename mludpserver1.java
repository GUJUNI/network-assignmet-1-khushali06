// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment
// ===================================================================================
// 2-a) UDP Program in java with multithreaded server for reverse the words of string entered by user.
// ===================================================================================

// ==> server-side programme:

import java.io.*;
import java.net.*;

public class UDPServer1 {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            ReverseThread t = new ReverseThread(serverSocket, IPAddress, port, receivePacket.getData());
            t.start();
        }
    }
}

class ReverseThread extends Thread {
    private DatagramSocket serverSocket;
    private InetAddress clientAddress;
    private int clientPort;
    private byte[] receiveData;
    
    public ReverseThread(DatagramSocket serverSocket, InetAddress clientAddress, int clientPort, byte[] receiveData) {
        this.serverSocket = serverSocket;
        this.clientAddress = clientAddress;
        this.clientPort = clientPort;
        this.receiveData = receiveData;
    }
    
    public void run() {
        String sentence = new String(receiveData);
        String[] words = sentence.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }
        byte[] sendData = sb.toString().getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
        try {
            serverSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// ===================================================================================
// Output
// ===================================================================================
// server:
// javac UDPServer1.java
// java UDPServer1
