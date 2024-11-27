import java.io.*;
import java.net.*;

public class Client {
    public Socket clientSocket  = null;
    public BufferedReader inFromUser = null;
    public DataOutputStream outToServer = null;

    Client(String IP, int PORT) {
        try {
            clientSocket = new Socket(IP, PORT);
            
            // Using BufferedReader to read user input from the console
            inFromUser = new BufferedReader(new InputStreamReader(System.in));
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            
            System.out.println("Please enter data: ");
            String line = "";
            while (!line.equals("Over")) {   
                try {
                    line = inFromUser.readLine();  // Read input from the user
                    outToServer.writeUTF(line);  // Send input to the server
                } catch (IOException e) {
                    System.out.println("IOExc in Loop");
                }
            }

            clientSocket.close();
            inFromUser.close();
            outToServer.close();
        } catch (UnknownHostException u) {
            System.out.println("Not Found");
        } catch (IOException i) {
            System.out.println("IO Error");
        }
    }

    public static void main(String args[]) {
        Client client = new Client("127.0.0.1", 5000);
    }
}
