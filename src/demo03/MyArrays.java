package demo03;

import java.util.Arrays;

/**
 * Arrays 工具类
 * 1.toString() 打印
 * 2.sort()     排序
 */
public class MyArrays {
    public static void main(String[] args) {
        int[] nArr=new int[]{23,45,34,54,237654,23,89886};
        System.out.println(Arrays.toString(nArr));
        Arrays.sort(nArr);
        System.out.println(Arrays.toString(nArr));
    }
}
