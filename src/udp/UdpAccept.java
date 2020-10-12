package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpAccept {

    public static void main(String[] args) throws Exception {
        // 定义一个接收端，并且指定了接收的端口号
        DatagramSocket socket = new DatagramSocket(8080);

        while (true) {
            byte[] buf = new byte[1024];
            // 解析数据包
            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            socket.receive(packet);

            String ip = packet.getAddress().getHostAddress();

            buf = packet.getData();

            String data = new String(buf, 0, packet.getLength());

            int res = Integer.parseInt(data, 2);

            System.out.println("收到 " + ip + " 发来的消息：" + res);

        }

    }
}