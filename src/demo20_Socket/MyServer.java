package demo20_Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    文件接收：   写入 F:/test_时间戳.mp4
        1.创建服务端套接字
        2.accept()监听
        3.获取输入流读取数据
        4.创建本地输出流对象
        5.关闭
 */
public class MyServer {
    static Socket so;

    public static void main(String[] args) throws IOException {
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Runnable run = () -> {
            try {
                //2.获取网络流,创建速度更快的缓冲字节流
                BufferedInputStream bis = new BufferedInputStream(so.getInputStream());
                //3.读取数据
                int len;
                byte[] bytes = new byte[1024];
                String fName = "F:/test_" + System.currentTimeMillis() + ".jpg";
                //3.1创建本输出流
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fName));
                while ((len = bis.read(bytes)) != -1) {
                    System.out.println(len);
                    bos.write(bytes, 0, len);
                }
                //注意：输出流一定要flush或close
                //关闭本地流
                bos.close();
                //3.2接收完成打印存放路径
                System.out.println(fName);
                //3.3并回复已上传
                OutputStream os = so.getOutputStream();
                os.write(("已上传:" + fName).getBytes());
                //3.5flus或shutdonw以刷新数据
                os.flush();
                so.shutdownOutput();
            } catch (Exception e) {
                System.out.println(e);
            }
        };
        //1.创建服务器ServerSocket套接字
        ServerSocket ss = new ServerSocket(8888);
        //使用循环
        while (true) {
            so = ss.accept();
            //使用线程池
            pool.submit(run);

        }
        //4.使用完毕，关闭套接字
//        ss.close();
    }
}
