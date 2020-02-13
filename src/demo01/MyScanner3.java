package demo01;

import java.util.Scanner;

/**
 * 从字符串中扫描
 */
public class MyScanner3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner("1 2 3 4 5 6 7 8  9");
        while (sc.hasNext()){
            System.out.println(sc.nextInt());
        }
    }
}
