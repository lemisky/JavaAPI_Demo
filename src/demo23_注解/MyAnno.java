package demo23_注解;

/*
    注解本质是一个继承Annotation接口的类接口
    注意事项：
        返回值：
            1.基本数据类型
            2.Enum 枚举类型
            3.其他注解类型
            4.String
            5.以上数据类型的 注解
    元注解：描述注解的基本（内置）注解
        @Target：描述注解作用的位置
        @Retention：描述注解被保留的阶段
        @Documented：描述注解是否被抽取到Api文档
        @Inherited：描述注解是否可被继承
    解析注解：
        使用反射。。。
 */

import java.lang.annotation.Target;

public @interface MyAnno {

    String name() default "MyName";
    int number();
    int value();    //value 属性名赋值时，如果只有一个，则 value可以省略
    String[] message();

}
