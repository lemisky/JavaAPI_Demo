package demo19_IO;

import java.io.FileWriter;
import java.io.IOException;

/*
    java.io.Writer  是所有字符输出流的上层接口
    其子类 OutputStreamWriter 的子类 FileWriter

    FileWriter(File file)
          在给出 File 对象的情况下构造一个 FileWriter 对象
    FileWriter(File file, boolean append)
          在给出 File 对象的情况下构造一个 FileWriter 对象。
    FileWriter(String fileName)
          在给出文件名的情况下构造一个 FileWriter 对象
    FileWriter(String fileName, boolean append)
          在给出文件名的情况下构造 FileWriter 对象，它具有指示是否挂起写入数据的 boolean 值。
 */
public class MyWriter {
    public static void main(String[] args) throws IOException {
//        write1();
        write2();
    }
    private static void write2() throws IOException {
        //使用FileWriter写文件
        //1.使用构造方法创建字符输出流对象
        FileWriter fw = new FileWriter("src/demo19_IO/fw.txt",true);
        //2.调用write方法
        fw.write("HelloWorld");
        fw.write("\r\n1234567",0,5);
        fw.write(68);

        //3.关闭流对象
        fw.close();
    }

    private static void write1() throws IOException {
        //使用FileWriter写文件
        //1.使用构造方法创建字符输出流对象
        FileWriter fw = new FileWriter("src/demo19_IO/fw.txt");
        //2.调用write方法
        fw.write("HelloWorld");
        fw.write("\r\n1234567",0,5);
        fw.write(68);

        //3.关闭流对象
        fw.close();
    }
}
