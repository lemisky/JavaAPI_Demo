package demo02_Random;

import java.util.Random;

public class MyRandom3 {
    public static void main(String[] args) {

        //带参数的构造函数
        //用于保存随机数结果
        Random random = new Random(111);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + random.nextInt(10000));
        }
        System.out.println();
        random.setSeed(111);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + random.nextInt(10000));
        }

    }
}
