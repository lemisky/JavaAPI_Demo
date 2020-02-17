package demo21_Stream;

/*
    针对于Lambda表达式的   方法引用
        用于简化Lambda表达式
 */
public class MyLambda {
    //打印参数字符串
    //打印处理后的字符串
    static void print(String s, LambdaInterface anInterface) {
        System.out.println(s);
        anInterface.reverse(s);
    }

    static void revese(String s) {
        System.out.println(new StringBuffer(s).reverse());
    }

    public static void main(String[] args) {
        //调用print方法
        //1.正常方式/普通方式
        print("abcdef", new LambdaInterface() {
            @Override
            public void reverse(String s) {
                revese(s);
            }
        });

        //2.标准lambda表达式
        print("wxyz", (String s) -> {
            revese(s);
        });

        //3.简化lambda表达式
        //简化规则
        //1.参数数据类型可以省略
        //2.当参数只有一个时，参数括号可以省略
        //3.当代码只有一行时，return {} ;    都可以省略
        print("123456", s -> revese(s));

        //4.使用方法引用
        /*
            使用条件，对象，方法存在。。。
            1.可以引用成员方法
            2.可以引用静态方法
            3.对于父类对象可以使用super关键字
            4.对于本类方法可以使用this
            5.对于构造函数，可以使用   对象名::new
            6.对于数组，可以使用 int[]:new
         */
        //对于本例：
        print("你是头猪", MyLambda::revese);
    }

}
