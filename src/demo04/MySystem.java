package demo04;

import java.util.Arrays;

/**
 * System 系统类
 */
public class MySystem {
    public static void main(String[] args) {
        //1.获取系统环境变量    System.getenv();
//        Map<String, String> getenv = System.getenv();
//        getenv.forEach((s1, s2) -> {
//            System.out.println(s1 + ":" + s2);
//        });

        //2.字符串拷贝   System.arraycopy()
//        int[] a = new int[]{1, 2, 3};
//        int[] b = new int[]{7, 8, 9, 9};
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
//        System.arraycopy(a, 1, b, 1, 1);
//        System.out.println(Arrays.toString(b));

        //3.获取标准时间 秒    1970/1/1 0点0分 到 现在的秒数
        //格林威治标准时间 1970 年 1 月 1 日的 00:00:00.000
        System.out.println(System.currentTimeMillis());
    }
}
