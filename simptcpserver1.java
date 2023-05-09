// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment
// ===================================================================================
// 3-a)Simple TCP client and server programe in java for convert string entered by user into uppercase
// ===================================================================================

// ===> server-side programme:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // create a server socket object
            ServerSocket serverSocket = new ServerSocket(9999);

            // wait for client connection
            System.out.println("Waiting for client connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            // read data from client and convert to uppercase
            String data = in.readLine();
            String result = data.toUpperCase();

            // send result back to client
            out.println(result);

            // close streams and socket
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// ===================================================================================
// Output
// ===================================================================================

// --server:
// javac Server.java
// java Server
// Waiting for client connection...
// Client connected



 