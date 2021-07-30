
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        System.out.println("Simple Echo Client");
        try {
            System.out.println("Waiting for connection…..");
            InetAddress localAddress = InetAddress.getLocalHost();
            Socket clientSocket = new Socket(localAddress, 3000); // 127.0.0.1
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            
            System.out.println("Connected to server whose localport is: "+ clientSocket.getPort());
            System.out.println("For me, my local port is: " + clientSocket.getLocalPort());

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter text: ");
                String inputLine = scanner.nextLine();
                if ("quit".equalsIgnoreCase(inputLine)) {
                    clientSocket.close();
                    break;
                }
                out.println(inputLine);
                String response = br.readLine();
                System.out.println("Server response: " + response);
            }
        } catch (IOException ex) {
        }
    } // end main
}// end class
