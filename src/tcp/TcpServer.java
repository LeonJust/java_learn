package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    public static void main(String[] args) throws IOException {
        //1：创建服务器的套接字
        ServerSocket ss = new ServerSocket(10086);
        //2:监听客户端的套接字,并且返回客户端的套接字
        //阻塞式方法
        Socket s = ss.accept();
        //3:获取输入流
        InputStream is = s.getInputStream();
        //4:读取数据
        byte[] by = new byte[1024];
        int num = 0;
        while((num = is.read())!=-1){
            System.out.print((char)num);
        }
        //5:关闭套接字
        s.close();


    }

}
