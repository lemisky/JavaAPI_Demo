package demo02_Random;

import java.util.Random;
import java.util.Scanner;

public class MyRandom4 {
    public static void main(String[] args) {
        //生成 c 个 a~b 之间的整数随机数
        Scanner sc = new Scanner(System.in);
        System.out.println("需要生成随机数的个数：");
        int c = sc.nextInt();
        System.out.println("生成随机数范围（3 5）：");
        int a = sc.nextInt();
        int b = sc.nextInt();

        //创建随机数Random对象
        Random r = new Random();
        for (int i = 0; i < c; i++) {
            System.out.println(r.nextInt(b - a) + a);
        }
    }
}
