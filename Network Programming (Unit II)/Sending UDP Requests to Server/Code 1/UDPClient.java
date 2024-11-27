import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(); // port not given --> will assign a random port

            Scanner sc = new Scanner(System.in);
            byte buf[];
            
            InetAddress ip = InetAddress.getLocalHost(); // gives the address of the localhost 
            String line = sc.nextLine();

            buf = line.getBytes();

            DatagramPacket dp = new DatagramPacket(buf, buf.length, ip, 1000); // where the server is hosted
            socket.send(dp);
            
            byte[] receiveBuf = new byte[1024];
            DatagramPacket receivedDatagram = new DatagramPacket(receiveBuf, 1024);
            
            socket.receive(receivedDatagram);
            String receivedString = new String(receivedDatagram.getData(), 0, receivedDatagram.getLength(), "UTF-8");

            System.out.println(receivedString);

            socket.close();
            sc.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
