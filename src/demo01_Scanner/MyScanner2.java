package demo01_Scanner;

import java.io.File;
import java.util.Scanner;

/**
 * 从文件中扫描
 */
public class MyScanner2 {
    public static void main(String[] args) throws Exception{
        //获取资源文件路径
        String path = MyScanner2.class.getClassLoader().getResource("demo01_Scanner/f1.txt").getPath();
        //创建资源File对象并实例化Scanner
        Scanner sc = new Scanner(new File(path));
        System.out.println(sc.next());
        System.out.println(sc.nextInt());
        System.out.println(sc.nextDouble());
        //过滤掉 \r
        //在Windows中，回车是\r\n
        //next()方法接收到一个\n就会结束，剩下一个\r就会被nextLine()接收掉
        //所以需要过滤一下
        sc.nextLine();
        System.out.println(sc.nextLine());
    }
}
