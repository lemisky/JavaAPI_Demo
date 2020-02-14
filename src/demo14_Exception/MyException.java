package demo14_Exception;

/**
 * java.lang.Throwable  异常类有两个子类：Exception、Error
 *  Exception：异常类，java运行中可能出现的问题
 *      编译期异常：编写代码时出现的异常，不处理将无法编译成功，例如 ClassNotFoundException
 *      运行时异常：RuntimeException，运行时才出现的异常，比如数组越界
 *  Error：程序出现的错误，致命的，必须审查修改代码
 *
 *  异常的处理方式：
 *      1.使用 throws 关键字抛出异常
 *          对于程序调用
 *      2.使用 try...catch[...finally{}]捕获异常
 */
public class MyException {
    public static void main(String[] args) throws Exception{
        try{

        }catch (Exception e){

        }finally {

        }

    }
}
