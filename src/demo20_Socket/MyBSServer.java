package demo20_Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*

 */
public class MyBSServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Socket so = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
//        String s;
//        while ((s=br.readLine())!=null){
//            System.out.println(s);
//        }

        String name = br.readLine().split(" ")[1].substring(1);

        //
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/demo20_Socket/index.html"));
        OutputStream os = so.getOutputStream();
        int len;
        byte[] bytes = new byte[1024];
        //http协议固定头
        os.write("HTTP/1.1 200 OK\r\n".getBytes());
        os.write("Content-Type:text/html\r\n".getBytes());
        os.write("\r\n".getBytes());
        //
        while ((len = bis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }
        so.shutdownOutput();
        so.close();
    }
}
