import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Date;
import java.time.LocalDateTime;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(4160);
        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        DatagramSocket socket = new DatagramSocket();
        server.receive(packet);
        
        Date d1 = new Date(1970, 1, 1);
        Date d2 = new Date(1970, 1, 2);
        long seconds = (d2.getTime()-d1.getTime())/1000;
        seconds+= (LocalDateTime.now().getHour()*60);
        seconds+= (LocalDateTime.now().getSecond());
        String str = "";
        str+=Integer.toBinaryString((int)seconds);
        System.out.println(str);
        buf = str.getBytes();
        

        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        packet = new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);
        server.close();
    }
}




