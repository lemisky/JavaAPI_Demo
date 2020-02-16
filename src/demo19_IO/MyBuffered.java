package demo19_IO;

import java.io.*;
import java.util.Arrays;

/**
 * 字符缓冲流
 * 1.输入流（读）：BufferedWriter
 * java.lang.Object
 * 继承者 java.io.Writer
 * 继承者 java.io.BufferedWriter
 * <p>
 * 构造函数：
 * BufferedWriter(Writer out)
 * 创建一个使用默认大小输出缓冲区的缓冲字符输出流。
 * BufferedWriter(Writer out, int sz)
 * 创建一个使用指定大小输出缓冲区的新缓冲字符输出流。
 * 常用方法：
 * newLine()
 * 写入一个行分隔符。
 * write(String s, int off, int len)
 * 写入字符串的某一部分。
 * 使用步骤：
 * 1.创建字符输出流
 * 2.创建缓冲输出流
 * 3.写
 * 4.关
 * 2.字符缓冲输入流
 * BufferedReader
 * java.lang.Object
 * 继承者 java.io.Reader
 * 继承者 java.io.BufferedReader
 * <p>
 * 构造函数：
 * 构造方法摘要
 * BufferedReader(Reader in)
 * 创建一个使用默认大小输入缓冲区的缓冲字符输入流。
 * BufferedReader(Reader in, int sz)
 * 创建一个使用指定大小输入缓冲区的缓冲字符输入流。
 * <p>
 * 常用方法：
 * readLine()
 * 读取一个文本行。
 * 使用步骤：
 * 1.创建字符输入流
 * 2.创建缓冲字符输入流
 * 3.读
 * 4.关
 */
public class MyBuffered {
    static String f = "src/demo19_IO/bw.txt";

    public static void main(String[] args) throws IOException {
//        bufout();
//        bufreader();

//        排序测试
        ff();
    }

    private static void ff() throws IOException {
        //创建字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("src/demo19_IO/t.txt"));
        //读取数据，存放到StringBuffer
        StringBuffer sb=new StringBuffer();
        String s;
        while ((s = br.readLine()) != null) {
            sb.append(s+",");
        }
        br.close();
        //排序
        String[] split = sb.toString().split(",");
        Arrays.sort(split);
        //创建字符缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/demo19_IO/t222.txt"));
        //循环输出
        for (int i = 0; i < split.length; i++) {
            bw.write(split[i] + "\r\n");
        }
        bw.close();
    }

    private static void bufreader() throws IOException {
        //1.创建字符输入流
        //2.创建缓冲字符输入流
        BufferedReader br = new BufferedReader(new FileReader(f));
        //3.读
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
        String s;
        //读到末尾，返回null
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        //4.关
        br.close();
    }

    private static void bufout() throws IOException {
        //1.创建字符输出流
        //2.创建缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        //3.写
        bw.write("what happen?");
        bw.newLine();
        bw.write("what happen?");
        //4.关
        bw.close();
    }
}
