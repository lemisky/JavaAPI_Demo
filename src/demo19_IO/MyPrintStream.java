package demo19_IO;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/*
    打印流  PrintStream
     java.lang.Object
      继承者 java.io.OutputStream
          继承者 java.io.FilterOutputStream
              继承者 java.io.PrintStream
     简介：
         PrintStream 为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。
     它还提供其他两项功能。与其他输出流不同，PrintStream 不会抛出 IOException；而是，
     异常情况仅设置可通过 checkError 方法测试的内部标志。另外，为了自动刷新，可以创建一个
     PrintStream；这意味着可在写入字节数组之后自动调用 flush 方法，可调用其中一个 println
     方法，或写入一个新行字符或字节 ('\n')。 PrintStream 打印的所有字符都使用平台的默认字
     符编码转换为字节。在需要写入字符而不是写入字节的情况下，应该使用 PrintWriter 类。

     构造函数：
         PrintStream(File file)
                   创建具有指定文件且不带自动行刷新的新打印流。
         PrintStream(File file, String csn)
                   创建具有指定文件名称和字符集且不带自动行刷新的新打印流。
         PrintStream(OutputStream out)
                   创建新的打印流。
         PrintStream(OutputStream out, boolean autoFlush)
                   创建新的打印流。
         PrintStream(OutputStream out, boolean autoFlush, String encoding)
                   创建新的打印流。
         PrintStream(String fileName)
                   创建具有指定文件名称且不带自动行刷新的新打印流。
         PrintStream(String fileName, String csn)
                   创建具有指定文件名称和字符集且不带自动行刷新的新打印流。

    新版打印流   PrintWriter
        java.lang.Object
            继承者 java.io.Writer
                继承者 java.io.PrintWriter
    处理中文时，推荐使用

 */
public class MyPrintStream {
    //synchronized
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        ps();
        PrintWriter pw = new PrintWriter("src/demo19_IO/pw.txt");
        pw.println("HelloWoeld");
        pw.print(99);
        pw.close();
    }

    private static void ps() throws FileNotFoundException, UnsupportedEncodingException {
        PrintStream ps = new PrintStream("src/demo19_IO/ps.txt", "gbk");
        ps.println("Java打印流 PrintStream 测试");
        System.setOut(ps);
        System.out.println("MyPrintStream.main");
        System.out.println(99);
        ps.close();
    }
}
