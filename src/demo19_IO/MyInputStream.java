package demo19_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.InputStream 接口 所有字节输入流的超类
 * 其直接子类
 * java.io  * 类 FileInputStream
 * java.io  * 类 ByteArrayInputStream
 */
public class MyInputStream {
    public static void main(String[] args) throws IOException {
        //字节输入流示例
//        input1();
        //文件拷贝
//        input2();
        //文件拷贝2
        input3();
    }

    private static void input3() throws IOException {
        //1.创建输入输出流对象
        FileInputStream fis = new FileInputStream("src/demo18_File/java_files_io.jpg");
        FileOutputStream fos = new FileOutputStream("src/demo19_IO/java_files_io.jpg");
        //2.边读边写
        //一次读写一个字节
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
    }

    private static void input2() throws IOException {
        //1.创建输入输出流对象
        FileInputStream fis = new FileInputStream("src/demo19_IO/fos.txt");
        FileOutputStream fos = new FileOutputStream("src/demo19_IO/fis.txt");
        //2.边读边写
        //一次读写一个字节
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }
        fos.close();
        fis.close();
    }

    private static void input1() throws IOException {
        //使用FileInputSteam读取文件
        /*
            使用步骤：
                1.常用构造方法
                    FileInputStream(String name)
                通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的路径名 name 指定。
                    FileInputStream(File file)
                通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的 File 对象 file 指定。
                2.使用文件字节输入流对象的read方法读取数据
                    read() 从此输入流中读取一个数据字节。
                    read(byte[] b, int off, int len) 从此输入流中将最多 len 个字节的数据读入一个字节数组中。
                3.使用完毕调用close()方法
         */
        //1.创建字节流对象
        FileInputStream fis = new FileInputStream("src/demo19_IO/fos.txt");
        //2.读取数据
        //一次读取一个
        int len = 0;
//        while ((len=fis.read())!=-1){
//            System.out.println((char) len);
//        }
        //一次读取多个，使用字符出租作为缓冲
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        fis.close();
    }
}
