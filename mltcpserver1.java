// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment
// ===================================================================================
// 4-a) A multithreaded TCP program in Java that allows clients to connect to the server and retrieve the current time from server.
// ===================================================================================

//===>server-side programme

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

public class TimeServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Listening on port 5000...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress());

                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            LocalDateTime currentTime = LocalDateTime.now();
            out.println("Current time is: " + currentTime);

            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// ===================================================================================
// Output
// ===================================================================================
// --server:
// javac TimeServer.java
// java TimeServer

// Server started. Listening on port 5000...
// Client connected from /127.0.0.1


