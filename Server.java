package base;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static int PORT = 9999;

    //1. 一个进程是否可以bind多个端口号?
    //2. 一个端口号是否可以被多个进程bind?
    //3. ServerSocket.accept是阻塞式方式，使用固定大小线程池会存在问题？
    //下来可以自行对比使用固定线程池 vs 缓冲线程池
    private static ExecutorService POOL = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        //启动了服务端程序：netstat -ano|findstr "9999"，可以显示进程的pid
        //pid是系统管理进程的方式，数据还是发送到端口中，pid是进程启动随机分配的
        //网络传输数据，使用端口号来定位程序，指定端口号启动程序就保证了服务器是固定端口
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            //阻塞等待客户端连接，有新的连接来，往下执行
            Socket client = server.accept();
            POOL.submit(new ServerTask(client));
        }
    }

    private static class ServerTask implements Runnable{
        private Socket client;
        public ServerTask(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            try {
                //处理client中的输入输出流，也就是发送/读取网络数据包
                InputStream is = client.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(isr);

                OutputStream os = client.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);

                String line;
                while ((line=br.readLine()) != null){
                    System.out.println("接收客户端数据："+line);
                    pw.println("响应："+line);
                    pw.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
