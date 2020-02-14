package demo01_Scanner;


import java.util.Scanner;

/**
 * @author foyou
 *
 * 关于导包：
 * 1.同包内，类引用无需import导包
 * 2.java.lang中，也无需导包
 * 3.其他则需使用import导包

 * Scanner 流扫描器，在指定的流中获取输入
 * 1.流中的任何数据都是字符串
 * 2.scanner中不同的方式是将字符串转换成不同的结果返回
 */

public class MyScanner {
    public static void main(String[] args) {
        //标准输入扫描器
        Scanner sc=new Scanner(System.in);

        //获取输入并输出
        //获取输入 字符串
        System.out.println("请输入一个字符串：");
        System.out.println(sc.next());
        //获取输入 int
        System.out.println("请输入一个数字：");
        System.out.println(sc.nextInt());
        //获取输入 double
        System.out.println("请输入一个double");
        System.out.println(sc.nextDouble());
        //获取输入的 一整行
        System.out.println("请输入一行:");
        //过滤掉多余 回车、\r等
        sc.nextLine();
        System.out.println(sc.nextLine());

    }
}
