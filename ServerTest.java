
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Fares Abu Ali
 */
public class ServerTest {

    public static void main(String[] args) {

        System.out.println("Simple Echo Server");

        try (ServerSocket serverSocket = new ServerSocket(3000)) {

            while (true) {
                System.out.println("Waiting for connection on my localport " + serverSocket.getLocalPort() + "...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket);

                // If you want to listen to multiple clients, the following while loop should be run in a separate thread
                // to not block the server.
                BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    System.out.println("Client: " + inputLine);
                    out.println(inputLine);
                }

                System.out.println("Client " + clientSocket + "has terminated connection...");

                //clientSocket.close();
            }
        } catch (IOException ex) {
        }

    }// end main

}// end class
