import java.io.*;
import java.net.*;

public class TCPClient {
    Socket clientSocket = null;
    DataOutputStream outFromClient = null;
    BufferedReader inFromUser = null;
    DataInputStream inFromServer = null;
    public TCPClient(String serverIP, int serverPort) {
        try {
            clientSocket = new Socket(serverIP, serverPort);

            outFromClient = new DataOutputStream(clientSocket.getOutputStream());
            inFromUser = new BufferedReader(new InputStreamReader(System.in));
            inFromServer = new DataInputStream(clientSocket.getInputStream());

            while(true) {
                System.out.println("Enter a sentence: ");
                String sentenceToServer = inFromUser.readLine();
                if (sentenceToServer.equals("over"))
                    break;
                
                outFromClient.writeUTF(sentenceToServer);
                String sentenceFromServer = inFromServer.readUTF();
                System.out.println(sentenceFromServer);
            }
            
            outFromClient.close();
            inFromUser.close();
            inFromServer.close();
            clientSocket.close();

        } catch (UnknownHostException u) {
            u.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TCPClient("127.0.0.1", 5000);
    }
}
