package demo19_IO;

import java.io.*;

/**
 * 普通字节流与缓冲字节流效率对比
 * test.mp4 8,266,777 字节(固态硬盘中)
 */
public class MyCopyTest {
    //固态硬盘中文件
    static String f1 = "D:/test.mp4";
    static String f2 = "D:/test222.mp4";
    //测试时请将源文件删除，否则会有很大偏差，因为都是毫秒级的，对于缓冲流影响较大

    public static void main(String[] args) throws IOException {
        //耗时（ms）:40257
//        System.out.println("耗时（ms）:"+c1());
        ////耗时（ms）:78
//        System.out.println("耗时（ms）:" + c2(1024));
        //耗时（ms）:16
//        System.out.println("耗时（ms）:" + c2(8192));
        //耗时（ms）:156
//        System.out.println("耗时（ms）:" + c3());
        //耗时（ms）:31
//        System.out.println("耗时（ms）:" + c4(1024));
        //耗时（ms）:16
        System.out.println("耗时（ms）:" + c4(8192));

    }

    private static long c4(int n) throws IOException {
        //获取时间
        long l = System.currentTimeMillis();
        //使用普通字节流拷贝文件
        //1.创建普通字节输入流用来读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
        //2.创建普通字节输出流用来写文件
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f2));
        //3.边写边读
        //一次读取一个字节
        int len = 0;
        byte[] bytes = new byte[n];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        //4.关闭
        bos.close();
        bis.close();
        return System.currentTimeMillis() - l;
    }

    private static long c3() throws IOException {
        //获取时间
        long l = System.currentTimeMillis();
        //使用普通字节流拷贝文件
        //1.创建普通字节输入流用来读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
        //2.创建普通字节输出流用来写文件
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f2));
        //3.边写边读
        //一次读取一个字节
        int len = 0;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }
        //4.关闭
        bos.close();
        bis.close();
        return System.currentTimeMillis() - l;
    }

    //使用普通字节流+字节缓冲数组
    private static long c2(int n) throws IOException {
        //获取时间
        long l = System.currentTimeMillis();
        //使用普通字节流拷贝文件
        //1.创建普通字节输入流用来读取文件
        FileInputStream fis = new FileInputStream(f1);
        //2.创建普通字节输出流用来写文件
        FileOutputStream fos = new FileOutputStream(f2);
        //3.边写边读
        //一次读取多个
        int len = 0;
        byte[] bytes = new byte[n];
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        //4.关闭
        fos.close();
        fis.close();
        return System.currentTimeMillis() - l;
    }

    //耗时（ms）:40257
    private static long c1() throws IOException {
        //获取时间
        long l = System.currentTimeMillis();
        //使用普通字节流拷贝文件
        //1.创建普通字节输入流用来读取文件
        FileInputStream fis = new FileInputStream(f1);
        //2.创建普通字节输出流用来写文件
        FileOutputStream fos = new FileOutputStream(f2);
        //3.边写边读
        //一次读取一个字节
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }
        //4.关闭
        fos.close();
        fis.close();
        return System.currentTimeMillis() - l;
    }
}
