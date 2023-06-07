// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment 
// ===================================================================================
// write Simple TCP client and server programe in java for display given number is prime or not
// ===================================================================================

// ==>server-side programme


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class PrimeServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // Port number

            System.out.println("Server started. Waiting for client...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String numberStr = reader.readLine();
                int number = Integer.parseInt(numberStr);

                boolean isPrime = checkPrime(number);

                writer.println(isPrime);

                reader.close();
                writer.close();
                clientSocket.close();

                System.out.println("Response sent to client.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
