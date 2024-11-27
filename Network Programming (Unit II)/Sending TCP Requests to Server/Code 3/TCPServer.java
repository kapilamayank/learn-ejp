import java.io.*;
import java.net.*;

public class TCPServer {
    ServerSocket welcomingSocket = null;
    DataInputStream inFromClient = null;
    DataOutputStream outToClient = null;
    Socket communicationSocket = null;
    public TCPServer() {
        try {
            welcomingSocket = new ServerSocket(5000);
            System.out.println("Waiting for Connection......");
            communicationSocket = welcomingSocket.accept();
            System.out.println("Connection Successful!");
            inFromClient = new DataInputStream(communicationSocket.getInputStream());
            outToClient = new DataOutputStream(communicationSocket.getOutputStream());

            while (true) { 
                try {
                    String receivedSentence = inFromClient.readUTF();
                    System.out.println("Sentence Received: " + receivedSentence);
                    String sentenceToSend = receivedSentence.toUpperCase();
                    outToClient.writeUTF(sentenceToSend);
                    outToClient.flush();
                } catch (EOFException e) {
                    break;
                }  
            }
            inFromClient.close();
            outToClient.close();
            communicationSocket.close();
            welcomingSocket.close();

        } catch (UnknownHostException u) {
            u.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TCPServer();
    }
}
