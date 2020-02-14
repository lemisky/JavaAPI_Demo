package demo02_Random;

import java.util.Random;

/**
 * @author foyou
 * 随机数 API
 */
public class MyRandom {

    public static void main(String[] args) {
        //无参构造
        Random random=new Random();
        System.out.println("//生成随机 整数");
        for (int i = 0; i < 5; i++) {
            System.out.print(random.nextInt()+"\t");
        }
        System.out.println();
        System.out.println("//生成随机 long");
        for (int i = 0; i < 5; i++) {
            System.out.print(random.nextLong()+"\t");
        }
        System.out.println();
        System.out.println("//生成指定范围 随机数");
        for (int i = 0; i < 5; i++) {
            //[0,10)
            System.out.print(random.nextInt(10)+"\t");
        }

    }
}
