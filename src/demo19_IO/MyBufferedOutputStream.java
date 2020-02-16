package demo19_IO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节缓冲输出流  java.io  * 类 BufferedOutputStream
 * java.lang.Object
 *   继承者 java.io.OutputStream
 *       继承者 java.io.FilterOutputStream
 *           继承者 java.io.BufferedOutputStream
 *  增强读写效率
 *  构造函数：
 *      BufferedOutputStream(OutputStream out)
 *           创建一个新的缓冲输出流，以将数据写入指定的基础输出流。
 *      BufferedOutputStream(OutputStream out, int size)
 *           创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的基础输出流。
 *  使用步骤：
 *      1.创建基本的字节输出流 FileOutputStream
 *      2.创建缓冲流
 *      3.读写数据
 *      4.关闭
 */
public class MyBufferedOutputStream {
    public static void main(String[] args) throws IOException {
        //1.创建基本的字节输出流 FileOutputStream
        FileOutputStream fos=new FileOutputStream("src/demo19_IO/buf.txt"/*,true*/);
        //2.创建缓冲流   默认大小为8192
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        //3.读写数据
        bos.write("BufferedOutputStream".getBytes());
        bos.write(99);
        //4.刷新关闭
        //不需要手动关闭fos
        bos.close();
    }
}
