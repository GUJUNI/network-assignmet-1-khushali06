// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment
// ===================================================================================
// 3-b)Simple TCP client and server programe in java for convert string entered by user into uppercase
// ===================================================================================


// ===>client-side programme:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // create a socket object and connect to server
            Socket socket = new Socket("localhost", 9999);

            // create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            // read input from user
            System.out.print("Enter a string: ");
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String data = userInput.readLine();

            // send data to server
            out.println(data);

            // read result from server and print
            String result = in.readLine();
            System.out.println("Result: " + result);

            // close streams and socket
            userInput.close();
            in.close();
            out.close();
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
// javac Client.java
// java Client

// Enter a string: khushali tank
// Result: KHUSHALI TANK


