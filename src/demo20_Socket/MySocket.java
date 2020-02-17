package demo20_Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    java socket 编程
    相关接口与类：
        客户端套接字：java.net 类 Socket extends java.lang.Object
        服务器套接字：java.net 类 ServerSocket extends java.lang.Object
    Socket：
        构造方法：
            Socket(String host, int port)
          创建一个流套接字并将其连接到指定主机上的指定端口号。
    常用方法：
        getOutputStream()
          返回此套接字的输出流。
        getInputStream()
          返回此套接字的输入流。
          shutdownInput()
        此套接字的输入流置于“流的末尾”。
          shutdownOutput()
        禁用此套接字的输出流。
     使用步骤：
        1.创建套接字，参数给定服务器地址和端口号
        2.获取网络字节流，读取或写入数据
        3.使用完毕，关闭套接字

    ServerSocket:
        构造方法：
            ServerSocket(int port)
          创建绑定到特定端口的服务器套接字。
        常用方法：
            accept()
          侦听并接受到此套接字的连接。
        使用步骤：
            1.创建服务器套接字
            2.获取客户端网络输入输出流进行读写
            3.使用完毕，关闭

    注意事项：
        1.输入输出流使用完毕，需要手动flush和shutdown，否则会导致阻塞
 */
public class MySocket {
    public static void main(String[] args) throws IOException {
        //开启服务器
        new Thread(()->{
            try {
                server();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        //连接服务器
        new Thread(()->{
            try {
                Thread.sleep(2000);
                client();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void server() throws IOException {
        //1.创建服务器套接字
        ServerSocket ss=new ServerSocket(8888);
        Socket accept = ss.accept();
        //2.获取客户端网络输入输出流进行读写
        InputStream is = accept.getInputStream();
        System.out.println(new String(is.readAllBytes()));
        accept.shutdownInput();
        OutputStream os=accept.getOutputStream();
        os.write("收到数据".getBytes());
        accept.shutdownOutput();
        //3.使用完毕，关闭
        ss.close();
    }

    private static void client() throws IOException {
        //1.创建套接字，参数给定服务器地址和端口号
        Socket socket=new Socket("127.0.0.1",8888);
        //2.获取网络字节流，读取或写入数据
        OutputStream os = socket.getOutputStream();
        os.write("java网络编程。".getBytes());
        socket.shutdownOutput();
        InputStream is=socket.getInputStream();
        System.out.println(new String(is.readAllBytes()));
        socket.shutdownInput();
        //3.使用完毕，关闭套接字
        os.close();
    }
}
