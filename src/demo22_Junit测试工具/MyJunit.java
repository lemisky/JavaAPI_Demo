package demo22_Junit测试工具;

import org.junit.jupiter.api.*;


public class MyJunit {
    @BeforeEach
    public void init(){
        System.out.println("开始方法 init");
    }
    @AfterEach
    public void close(){
        System.out.println("MyJunit.close");
    }
    @Test
    public void testAdd() {
        System.out.println("测试类");
        int result=8-3;
        Assertions.assertEquals(5,result);
    }
}
