package udp;

import com.sun.jdi.IntegerType;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSend {

    public static void main(String[] args) throws Exception {
        int sum = 0;
        for(int i = 0 ; i < 10 ; i++) {
            DatagramSocket socket = new DatagramSocket();
            int a = i;
            sum += a;
            byte[] buf = Integer.toBinaryString(sum).getBytes();
            //将数据打包
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.147.65"), 8080);
            socket.send(packet);
            socket.close();
        }
    }

}
