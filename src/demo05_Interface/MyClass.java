package demo05_Interface;

public class MyClass implements MyInterface01 {
    @Override
    public void m1() {
        System.out.println("实现接口中的抽象方法");
    }

}
