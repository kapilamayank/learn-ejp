import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(1000, InetAddress.getLocalHost());
            
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, 1024);

            socket.receive(dp);

            String receivedData = new String(dp.getData(), 0, dp.getLength(), "UTF-8");
            receivedData = receivedData.toUpperCase();

            DatagramPacket toSend = new DatagramPacket(receivedData.getBytes(), receivedData.getBytes().length, dp.getAddress(), dp.getPort());
            socket.send(toSend);
            
            socket.close();
        } catch (IOException se) {
            System.err.println(se);
        }
    }
}
