package demo19_IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节输入缓冲流  BufferedInputStream
 * java.lang.Object
 *   继承者 java.io.InputStream
 *       继承者 java.io.FilterInputStream
 *           继承者 java.io.BufferedInputStream
 *  构造函数：
 *      BufferedInputStream(InputStream in)     //默认size为8192
 *           创建 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
 *      BufferedInputStream(InputStream in, int size)
 *           创建具有指定缓冲区大小的 BufferedInputStream，并保存其参数，即输入流 in，以便将来使用。
 *  使用步骤：
 *      1.创建基本字节输入流
 *      2.创建字节缓冲输入流
 *      3.读取数据
 *      4.关闭流
 */
public class MyBufferedInputStream {
    public static void main(String[] args) throws IOException {
        //1.创建基本字节输入流
        FileInputStream fis=new FileInputStream("src/demo19_IO/buf.txt");
        //2.创建字节缓冲输入流
        BufferedInputStream bis=new BufferedInputStream(fis/*,8192*/);
        //3.读取数据
        System.out.println(new String(bis.readAllBytes()));
        //4.关闭
        bis.close();
    }
}
