import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(2500);

            byte[] receiveBuffer = new byte[1024];
            DatagramPacket dpRec = new DatagramPacket(receiveBuffer, 1024);
            serverSocket.receive(dpRec);

            String receivedLine = new String(dpRec.getData());
            String lineToSend = receivedLine.toUpperCase();

            byte[] sendBuffer = lineToSend.getBytes();
            DatagramPacket dpSend = new DatagramPacket(sendBuffer, 0, sendBuffer.length, dpRec.getAddress(), dpRec.getPort());

            serverSocket.send(dpSend);

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   
