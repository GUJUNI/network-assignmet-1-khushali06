// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment
// ===================================================================================
// 4-b) A multithreaded TCP program in Java that allows clients to connect to the server and retrieve the current time from server.
// ==================================================================================

===>client-side programme

import java.io.*;
import java.net.*;

public class TimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = in.readLine();
            System.out.println(message);

            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// ===================================================================================
// Output
// ===================================================================================

// --client:
// javac TimeClient.java
// java TimeClient

// Connected to server
// Current time is: 2023-04-26T19:52:41.891
