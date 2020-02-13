package demo06;

/**
 * 1.成员内部类
 */
public class InnerClass {
    public void m(){
        System.out.println("外部类方法");
        //局部内部类
        class jb_inner{
            public void mm3(){
                System.out.println("局部内部类");
            }
        }
        new jb_inner().mm3();
    }

    //成员内部类
    public class Inner{
        public void mm(){
            System.out.println("内部类方法");
        }
    }

    public static class StaticInner{
        public void mm2(){
            System.out.println("共有静态成员内部类");
        }
    }
}
