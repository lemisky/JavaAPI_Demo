package demo14_Exception;

/**
 * java.lang.Throwable  异常类有两个子类：Exception、Error
 *  Exception：异常类，java运行中可能出现的问题
 *      编译期异常：编写代码时出现的异常，不处理将无法编译成功，例如 ClassNotFoundException
 *      运行时异常：RuntimeException，运行时才出现的异常，比如数组越界
 *  Error：程序出现的错误，致命的，必须审查修改代码
 *
 *  常用方法：
 *      getMessage();       //打印信息
 *      toString();         //打印异常名称和信息
 *      printStackTrace();  //打印详细的堆栈信息
 *
 *  异常的处理方式：
 *      1.使用 throws 关键字抛出异常
 *      注意事项：
 *          ①对于函数调用异常，调用者抛出的异常必须能涵盖被调用函数抛出的异常。
 *          ②对于继承关系的函数重写（覆盖），重写的函数抛出异常必须能 被 父类函数抛出的异常涵盖
 *      2.使用 try...catch[...finally{}]捕获异常
 *      注意事项：
 *          ①finally语句块中的语句总是能被执行，通常用来关闭链接流等。
 *          ②若在finally语句块中含有 return 语句，那么函数将总是会返回 finally 中返回的数据。
 *
 *  自定义异常类：
 *      创建方式：实现 Exception 或 RuntimeException 类，类名一般为 XXXEXception
 *
 */
public class MyException {

    public static void main(String[] args) throws Exception{

        System.out.println(test());     //789

        //自定义异常类测试
        throw new TestException("自定义异常类测试");
//        Exception in thread "main" demo14_Exception.TestException: 自定义异常类测试
//	at demo14_Exception.MyException.main(MyException.java:36)

    }

    //finally语句含有return测试
    //总是会返回789
    private static int test() {
        try{
            return 123;
        }catch (Exception e){
            return 456;
        }finally {
            return 789;
        }
    }

}
