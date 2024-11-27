import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            String lineToSend = inFromUser.readLine();

            byte[] sendBuffer = lineToSend.getBytes();
            
            DatagramPacket dpSend = new DatagramPacket(sendBuffer, 0, sendBuffer.length, InetAddress.getLocalHost(), 2500);
            clientSocket.send(dpSend);

            byte[] recBuffer = new byte[1024];
            DatagramPacket dpRec = new DatagramPacket(recBuffer, 1024);
            clientSocket.receive(dpRec);
            String receivedLine = new String(dpRec.getData());
            System.out.println(receivedLine);

            clientSocket.close();
        } catch(IOException e) {
            System.err.print(e);
        }
    }
}
