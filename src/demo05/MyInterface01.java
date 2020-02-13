package demo05;

public interface MyInterface01 {
    //1.抽象方法
    //public abstract 可省略
    public abstract void m1();

    //2.常量
    //必须赋值，且为public static final
    public static final int Interface_Const=999;

    //3.默认方法
    //使用default关键字
    //未来接口升级提供方便
    public default void m2(){
        m4();
        System.out.println("//3.默认方法");
    }

    //4.静态方法
    public static void m3(){
        System.out.println("//4.静态方法");
    }

    //5.私有方法
    //解决默认方法中相同代码问题
    private void m4(){
        System.out.println("//5.私有方法");
    }
}
