package demo23_注解.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestAnno {

    @MyAnnotation(className = "demo23_注解.annotation.MyUtils", method = "show")
    public void testAnno() throws NoSuchMethodException {

    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        //解析注解测试类
        System.out.println("=====");
        /*
            此处居然无效，莫非是没有实例化对象
            之所以无效是因为，没有添加 保留的生命周期为运行时
            @Retention(RetentionPolicy.RUNTIME)

      MyAnnotation testAnno = TestAnno.class.getDeclaredMethod("testAnno").getAnnotation(MyAnnotation.class);
         */
        MyAnnotation testAnno = TestAnno.class.getDeclaredMethod("testAnno").getAnnotation(MyAnnotation.class);
        String className = testAnno.className();
        String method = testAnno.method();
        //
        System.out.println(className);
        System.out.println(method);

        //创建对象并调用方法
        Class<?> name = Class.forName(className);
        Method method1 = name.getDeclaredMethod(method,String.class);
        Object obj = name.newInstance();
        method1.invoke(obj,"自定义注解解析~");
    }

}
