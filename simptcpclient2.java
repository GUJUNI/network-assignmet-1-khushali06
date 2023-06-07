
// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment 
// ===================================================================================
// write Simple TCP client and server programe in java for display given number is prime or not
// ===================================================================================

// ==>client-side programme



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class PrimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234); // Server IP address and port number
            System.out.println("Connected to server.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter a number: ");
            String numberStr = reader.readLine();

            writer.println(numberStr);

            BufferedReader responseReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = responseReader.readLine();

            boolean isPrime = Boolean.parseBoolean(response);

            if (isPrime) {
                System.out.println(numberStr + " is a prime number.");
            } else {
                System.out.println(numberStr + " is not a prime number.");
            }

            reader.close();
            writer.close();
            responseReader.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// ===================================================================================
// Output
// ===================================================================================

// 
/*
--server:

java PrimeServer
Server started. Waiting for client...
Client connected.
Response sent to client.

--client

java PrimeClient
Connected to server.
Enter a number: 17
17 is a prime number.
 */