package demo20_Socket;

import java.io.*;
import java.net.Socket;

/*
    文件上传小示例
        1.上传文件 D:/test.mp4
        2.创建Socket连接（在此之前需先运行服务器端）
        3.创建本地流对象，读取数据
        4.获取网络流对象，写入数据
        5.使用完毕关闭
 */
public class FileUpload {
    public static void main(String[] args) throws IOException {
        //上传文件路径
        String upload = "D:/test.mp4";
//        String upload = "E:\\Users\\foyou\\Pictures\\10-14-Night.jpg";
//        upload(upload);
    }

    //只能上传，无法携带数据
    private static void upload(String upload) throws IOException {
        //1.创建客户端套接字，给定服务器ip及端口
        Socket so = new Socket("127.0.0.1", 8888);
        //2.创建本地缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(upload));
        //2.1获取网络输出流，并创建更为快速的缓冲流
        BufferedOutputStream bos = new BufferedOutputStream(so.getOutputStream());
//        OutputStream bos = so.getOutputStream();
        //3.读取数据并上传
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            System.out.println(len);
            bos.write(bytes, 0, len);
        }
        //关闭本地输入流
        bis.close();
        //3.1上传完毕 flush/shutdown

        //注意注意：由于使用的BufferedOutputStream，所以这里必须flush(),否则最后会丢失最后部分数据
        bos.flush();

        so.shutdownOutput();
        //3.2接收返回的数据
        System.out.println(new String(so.getInputStream().readAllBytes()));
        //4.关闭
        so.close();
    }
}
