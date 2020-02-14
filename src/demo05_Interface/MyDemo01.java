package demo05_Interface;

/**
 * 关于接口
 */
public class MyDemo01 {
    public static void main(String[] args) {
        MyClass myClass=new MyClass();
        myClass.m1();
        myClass.m2();
        System.out.println(MyInterface01.Interface_Const);
        MyInterface01.m3();
    }
}
