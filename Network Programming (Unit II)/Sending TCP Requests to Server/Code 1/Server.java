import java.io.*;
import java.net.*;

public class Server {
    public ServerSocket welcomingSocket = null;
    public Socket connectionSocket = null;
    public DataInputStream inFromUser = null;
    
    Server(int PORT) {
        try {
            welcomingSocket = new ServerSocket(PORT);
            System.out.println("Waiting for client connection request.....");

            connectionSocket = welcomingSocket.accept(); // the code is blocked here until a client request is received

            inFromUser = new DataInputStream(new BufferedInputStream(connectionSocket.getInputStream()));
            
            String line = "";
            while (!line.equals("Over")) {
                line = inFromUser.readUTF();
                System.out.println(line);
            }

            System.out.println("Closing the connection.....");
            connectionSocket.close();
            inFromUser.close();
        } catch (UnknownHostException u) {
            System.out.print("Host Error");
        } catch (IOException i) {
            System.out.print("Error");
        } 
    }

    public static void main(String args[]) {
        Server server = new Server(5000);
    }
}