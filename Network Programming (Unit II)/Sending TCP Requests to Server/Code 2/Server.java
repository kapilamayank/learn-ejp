import java.io.*;
import java.net.*;

public class Server {
    public DataInputStream inFromUser = null;
    public DataOutputStream outToUser = null;
    public ServerSocket welcomingSocket = null;
    public Socket connectionSocket = null;

    Server(int PORT) {
        try {
            welcomingSocket = new ServerSocket(PORT);
            System.out.println("Waiting for connection...");

            connectionSocket = welcomingSocket.accept();
            inFromUser = new DataInputStream(connectionSocket.getInputStream());
            // new BufferedInputStream will buffer the socket input stream
            outToUser = new DataOutputStream(connectionSocket.getOutputStream());

            String line = "";
            while (!line.equals("done")) {
                try {
                    line = inFromUser.readUTF();
                    outToUser.writeUTF(line.toUpperCase());
                    outToUser.flush(); // to send the data immediately
                } catch (IOException e) {
                    System.err.print(e);
                }
            }

            System.out.println("Closing the connection....");
            inFromUser.close();
            outToUser.close();
            connectionSocket.close();
            welcomingSocket.close();
        } catch (UnknownHostException u) {
            System.err.print(u);
        } catch (IOException i) {
            System.err.print(i);
        }
    }

    public static void main(String[] args) {
        Server server = new Server(5500);
    }
}
