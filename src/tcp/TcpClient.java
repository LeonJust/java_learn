package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        //1：创建客户端的套接字  做连接  指定服务器的ip+端口
        Socket s = new Socket("192.168.147.65", 10086);
        //2:获取输出流
        OutputStream os = s.getOutputStream();
        //3:写数据
        for(int i = 0; i < 58; i++) {
            os.write(65+i);
        }

        //4:关闭套接字
        s.close();


    }

}