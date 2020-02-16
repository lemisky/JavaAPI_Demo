package demo19_IO;

import java.io.FileReader;
import java.io.IOException;

/*
        字符输入流
    java.io.Reader接口
        是所有字符输入流的超类
        其直接子类（实现类）：java.io.InputStreamReader,
        FileReader extends InputStreamReader
 */
public class MyReader {

    public static void main(String[] args) throws IOException {
        //字符流读取数据
        reader();
    }

    private static void reader() throws IOException {
        //1.创建FileReader对象
        FileReader fr = new FileReader("src/demo19_IO/fos.txt");
        //2.调用对象的read()方法，每次读取一个字符
        int len = 0;
//        while ((len = fr.read()) != -1) {
//            System.out.print((char) len);
//        }
        //一次读取多个
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }
        //3.关闭对象
        fr.close();
    }


}
