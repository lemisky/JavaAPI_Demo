package demo18_File;

import java.io.File;
import java.io.IOException;

/**
 * File 文件类
 */
public class MyFile {
    public static void main(String[] args) throws IOException {
//        m1();
//        m2();
//        m3();
//        m4();
//        m5();

        //6.递归遍历本项目目录
        File proFile = new File(".");

        dg(proFile, "");


    }

    private static void dg(File file, String nt) {
        //不管是文件还是文件夹，都需要打印名称
        System.out.println(nt + file.getName());
        //判断是否为文件，是则返回，否则继续
        if (file.isFile()) {
            return;
        }
        //递归文件夹
        for (File f :
                file.listFiles()) {
            dg(f, nt + "\t");
        }
    }

    private static void m5() {
        //5.遍历C根目录
        //$Recycle.Bin
        //Android
        //bootTel.dat
        //Documents and Settings
        //hiberfil.sys
        //PerfLogs
        //Program Files
        //Program Files (x86)
        //ProgramData
        //python27-x64
        //Recovery
        //System Volume Information
        //Users
        //Windows
        File cpan = File.listRoots()[0];
        for (String s : cpan.list()) {
            System.out.println(s);
        }
    }

    private static void m4() {
        //4.获取根目录（在Windows为盘符）
        for (File f :
                File.listRoots()) {
            f.getAbsolutePath();    //C:\...
        }
    }

    private static void m3() throws IOException {
        //3.File类静态方法创建临时文件
        File tempFile = File.createTempFile("123", "456");
        System.out.println(tempFile.getAbsolutePath());
    }

    private static void m2() {
        //2.File类的静态变量
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
    }

    private static void m1() {
        //1.新建、删除 文件，文件夹
        File file = new File("f1.txt");
//        file.createNewFile();
        //删除文件
        file.delete();
        File dir = new File("dir1");
//        dir.mkdir();
        //删除文件夹
        dir.delete();
    }
}
