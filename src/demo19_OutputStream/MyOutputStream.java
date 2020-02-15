package demo19_OutputStream;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件IO流中包含，字节输入输出流和字符输入输出流
 *
 *  java.io  * 类 OutputStream
 *  直接已知子类  ByteArrayOutputStream, FileOutputStream
 */
public class MyOutputStream {
    public static void main(String[] args) throws IOException {
//        output1();
//        output2();
        output3();
    }

    private static void output3() {
        //以ByteArrayOutputStream实现以上需求
        //此类实现了一个输出流，其中的数据被写入一个字节数组。缓冲区会随着数据的不断写入而自动增长。可使用 toByteArray() 和 toString() 检索数据。
        //
        //关闭 ByteArrayOutputStream 无效。在关闭此流后且没有生成 IOException 时，可以调用此类中的该方法。
        /**
         * 使用步骤：
         *  1.构造函数
         *      ByteArrayOutputStream()
         *           创建一个新的字节数组输出流。
         *      ByteArrayOutputStream(int size)
         *           创建一个新的字节数组输出流，它具有指定大小的缓冲区容量（以字节为单位）。
         *  2.使用write()方法向流中写数据
         *  3.最后使用 toString()或者toByteArray() 获取数据
         */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(97);
        bos.write(98);
        bos.write(99);
        bos.write(100);
        //abcd
        System.out.println(bos.toString());
    }


    private static void output2() throws IOException {
        //以追加形式打开文件
        FileOutputStream fos = new FileOutputStream("src/demo19_OutputStream/fos.txt",true);
        //write(byte[] b, int off, int len)
        //          将指定字节数组中从偏移量 off 开始的 len 个字节写入此输出流。
        fos.write("AA\r\n以追加形式打开文件BB".getBytes(),1,18);
        fos.flush();
        fos.close();
    }

    //AACDb
    //Java文件流
    private static void output1() throws IOException {
        //使用FileOutputStream演示 字节输出流 OutputStream
        /**
         * 使用步骤：
         *  1.构造方法
         *      FileOutputStream(File file)
         *           创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
         *      FileOutputStream(File file, boolean append)
         *           创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
         *      使用参数表示追加还是覆盖
         *      FileOutputStream(String name)
         *           创建一个向具有指定名称的文件中写入数据的输出文件流。
         *  2.使用write()方法向FileOutputStream对象中写入字节数据
         *  3.使用完成后，flush()刷新缓冲流，使用close()关闭流对象
         */

        //  创建一个新文件（存在则覆盖）
        //1.使用相对路径定义文件路径，会自动创建该文件
        FileOutputStream fos = new FileOutputStream("src/demo19_OutputStream/fos.txt");
        //写入单个字节
        fos.write(65);
        fos.write('A');
        //写入字符数组
        fos.write(new byte[]{67,68,98});
        //写入换行  windows:\r\n    Linux:\n    MacOS:\r
        fos.write("\r\n".getBytes());
        //写入字符串
        fos.write("Java文件流".getBytes());
        //最好刷新一下缓冲流
        fos.flush();
        fos.close();

    }
}
