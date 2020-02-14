package demo06_InnerClass;

/**
 * 关于内部类
 * 小结：
 * 1.内部类 分类：成员内部类（类中）、局部内部类（方法中）、匿名内部类
 * 成员内部：
 * 外部类.内部类 类名 = new 外部类().new 内部类();
 * 局部内部类：
 * 局部内部类无需权限修饰符修饰，外部无法调用（反射大法除外）
 * 匿名内部类：只能使用一次
 * <p>
 * 外部类：是能使用 public 修饰符，或者不写（默认 default）
 */
public class MyInner {
    public static void main(String[] args) throws Exception {
        //公有 成员内部类的使用
        InnerClass.Inner inner = new InnerClass().new Inner();
        inner.mm();
        //共有 静态成员内部类
        InnerClass.StaticInner staticInner = new InnerClass.StaticInner();
        staticInner.mm2();
        //局部 内部类
        InnerClass innerClass = new InnerClass();
        innerClass.m();
        //使用反射调用局部内部类
        //内部类都有一个隐藏的外部类对象
        Class<?> jb_inner = Class.forName("demo06_InnerClass.InnerClass$1jb_inner");
        Object o = jb_inner.getDeclaredConstructor(InnerClass.class).newInstance(innerClass);
        jb_inner.getDeclaredMethod("mm3").invoke(o);

    }
}
