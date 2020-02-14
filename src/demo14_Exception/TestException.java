package demo14_Exception;

/**
 * 自定义异常类
 *  1.实现Exception或RuntimeException
 *  2.添加空参数构造方法和含异常信息的构造方法
 */
public class TestException extends RuntimeException {
    //空参数构造方法
    public TestException() {
        super();
    }

    //带异常信息构造方法
    public TestException(String message) {
        super(message);
    }
}
