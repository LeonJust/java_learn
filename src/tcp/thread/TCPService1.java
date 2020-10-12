package tcp.thread;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TCPService1 {
    public static final String SERVICE_IP = "127.0.0.1";

    public static final int SERVICE_PORT = 10101;

    public static final char END_CHAR = '#';

    public static void main(String[] args) {
        TCPService1 service1 = new TCPService1();
        service1.startService();
    }

    private void startService(){
        try {
            InetAddress address = InetAddress.getByName(SERVICE_IP);
            Socket connect = null;
            ExecutorService pool = new ThreadPoolExecutor(5);
            try (ServerSocket service = new ServerSocket(SERVICE_PORT,5,address)){
                while(true){
                    connect = service.accept();
                    //创建一个任务
                    ServiceTask serviceTask = new ServiceTask(connect);
                    //放入线程池等待运行
                    pool.execute(serviceTask);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(connect!=null)
                    connect.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ServiceTask implements Runnable{
        private Socket socket;

        ServiceTask(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                StringBuilder receiveMsg = new StringBuilder();
                InputStream in = socket.getInputStream();
                for (int c = in.read(); c != END_CHAR; c = in.read()) {
                    if(c ==-1)
                        break;
                    receiveMsg.append((char)c);
                }
                String response = "Hello world " + receiveMsg.toString() + END_CHAR;
                Thread.currentThread().sleep(5000);
                OutputStream out = socket.getOutputStream();
                out.write(response.getBytes());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(socket!=null)
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}
