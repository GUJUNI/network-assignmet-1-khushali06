// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment 
// ===================================================================================
// write A multithreaded TCP program in Java that allows clients to send two number and retrieve the multiplication of those number from server.
// ===================================================================================

// ==>client-side programme

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class TCPClient {
    public static void main(String[] args) {
        String serverIP = "localhost"; // IP address of the server
        int serverPort = 12345; // Port number of the server
        
        try {
            Socket socket = new Socket(serverIP, serverPort);
            
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            
            // Read two numbers from the user
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the first number: ");
            String number1Str = reader.readLine();
            int number1 = Integer.parseInt(number1Str);
            
            System.out.print("Enter the second number: ");
            String number2Str = reader.readLine();
            int number2 = Integer.parseInt(number2Str);
            
            // Send the two numbers to the server
            output.println(number1);
            output.println(number2);
            
            // Receive the result from the server
            String result = input.readLine();
            System.out.println("Server response: " + result);
            
            // Close the connection
            socket.close();
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
Client connected: 127.0.0.1

--client:

 java TCPClient
Enter the first number: 3
Enter the second number: 13
Server response: Result: 39
 */