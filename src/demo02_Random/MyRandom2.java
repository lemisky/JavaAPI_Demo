package demo02_Random;

/**
 * Math 随机数
 */
public class MyRandom2 {
    public static void main(String[] args) {
        //Math类随机数方法，默认生成 0~1 （含0不含1）之间的double数
        System.out.println(Math.random());

        //生成 1~8 之间的数
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print((int) Math.floor(Math.random() * 7 + 1) + "\t");
            //生成 [a,b)   Math.random()*(a-1)+b;
        }

    }
}
