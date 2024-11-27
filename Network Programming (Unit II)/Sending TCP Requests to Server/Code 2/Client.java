import java.io.*;
import java.net.*;

public class Client {
    public Socket connectionSocket = null;
    public BufferedReader inFromUser = null;
    public DataInputStream inFromServer = null;
    public DataOutputStream outToServer = null;

    Client(String IP, int PORT) {
        try {
            connectionSocket = new Socket(IP, PORT);

            inFromUser = new BufferedReader(new InputStreamReader(System.in));
            outToServer = new DataOutputStream(connectionSocket.getOutputStream());
            inFromServer = new DataInputStream(connectionSocket.getInputStream());

            String line = "";
            while (!line.equals("done")) {
                try {
                    line = inFromUser.readLine();
                    outToServer.writeUTF(line);
                    outToServer.flush(); // Ensure data is sent immediately
                } catch (IOException e) {
                    System.err.println("IO Error: " + e);
                }
            }

            // Receive responses from the server
            line = "";
            while (!line.equals("DONE")) {
                try {
                    line = inFromServer.readUTF();
                    System.out.println(line);
                } catch (IOException e) {
                    System.err.println("IO Error: " + e);
                }
            }

            connectionSocket.close();
            inFromServer.close();
            outToServer.close();
            inFromUser.close();
        } catch (UnknownHostException u) {
            System.err.println("Unknown Host: " + u);
        } catch (IOException i) {
            System.err.println("IO Error: " + i);
        }
    }

    public static void main(String[] args) {
        new Client("127.0.0.1", 5500);
    }
}

