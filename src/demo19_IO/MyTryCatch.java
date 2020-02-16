package demo19_IO;

import java.io.FileOutputStream;

/**
 * 在新JDK中，1.7起，可以把流的定义放到try括号中
 * 具体如下：
 */
public class MyTryCatch {
    public static void main(String[] args) {
        //可自动关闭
        try(FileOutputStream fos=new FileOutputStream("src/demo19_IO/try.txt")){

        }catch (Exception e){

        }
    }
}
