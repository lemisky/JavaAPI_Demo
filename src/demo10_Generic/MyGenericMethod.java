package demo10_Generic;

/**
 * 定义带有泛型的方法
 */
public class MyGenericMethod {
    public <E> void m(E v){
        System.out.println(v);
    }
}
