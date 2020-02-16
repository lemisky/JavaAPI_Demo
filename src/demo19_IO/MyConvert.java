package demo19_IO;

import java.io.*;

/*
    转换流：OutputStreamWriter，InputStreamReader
        OutputStreamWriter
            1.继承关系
                java.lang.Object
            继承者 java.io.Writer
              继承者 java.io.OutputStreamWriter
            2.构造函数
                OutputStreamWriter(OutputStream out, String charsetName)
            创建使用指定字符集的 OutputStreamWriter。
            3.使用布步骤
                1.创建字节输出流
                2.创建转换字符输出流 OutputStreamWriter 并设置字符集
                3.调用方法写数据
                4.关闭


 */
public class MyConvert {

    static String utf = "src/demo19_IO/utf.txt";
    static String gbk = "src/demo19_IO/gbk.txt";

    public static void main(String[] args) throws IOException {

//        write_utf();
//        write_gbk();
        f1();

    }

    private static void f1() throws IOException {
        //示例：将utf编码文件 "src/demo19_IO/java_content.txt"  转为gbk编码
        //1.创建字符输入流读取 utf 编码文件
        BufferedReader br = new BufferedReader(new FileReader("src/demo19_IO/java_content.txt"));
        //2.创建字符转换流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/demo19_IO/java_content_gbk.txt"), "gbk"));
        //开始读写
        int len;
        while ((len = br.read()) != -1) {
            bw.write(len);
        }
        bw.close();
        br.close();
    }

    private static void write_gbk() throws IOException {
        //1.创建字节输出流
        //2.创建转换字符输出流 OutputStreamWriter
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(gbk), "gbk");
        //3.调用方法写数据
        osw.write("转换流测试 - 国标gbk");
        //4.关闭
        osw.close();
    }

    private static void write_utf() throws IOException {
        //1.创建字节输出流
        //2.创建转换字符输出流 OutputStreamWriter
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(utf), "utf-8");
        //3.调用方法写数据
        osw.write("转换流输出测试");
        //4.关闭
        osw.close();
    }
}
