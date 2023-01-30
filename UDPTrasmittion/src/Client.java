import java.io.*;
import java.net.*;
import java.sql.Date;
import java.time.LocalDateTime;

public class Client {
    public static void main(String[] args) throws Exception {
       
        DatagramSocket client = new DatagramSocket();
        InetAddress add = InetAddress.getByName("localhost");
        String str = "";
        byte[] buf = str.getBytes();
        DatagramPacket p = new DatagramPacket(buf, buf.length,add,4160);
        client.send(p);

        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        client.receive(packet);
        String response = new String(packet.getData());
        System.out.println("Ciao"+ response);
        client.close();
    }
}
