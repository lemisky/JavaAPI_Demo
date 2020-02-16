package demo19_IO;

import java.io.Serializable;

/*
    对象流，又称之为序列化流，用于将对象打印到文件中
        ObjectOutputStream
    java.lang.Object
      继承者 java.io.OutputStream
          继承者 java.io.ObjectOutputStream
    构造方法：
        ObjectOutputStream()
          为完全重新实现 ObjectOutputStream 的子类提供一种方法，让它不必分配仅由 ObjectOutputStream 的实现使用的私有数据。
        ObjectOutputStream(OutputStream out)
          创建写入指定 OutputStream 的 ObjectOutputStream。
    注意事项：
        1.被序列化的对象必须实现 Serializable 接口
        2.序列化类每次被重新编译后都会生成一个新的 serialVersionUID ，从而导致反序列化时失败，
    为了解决这一问题，可以自定义一个 static final long serialVersionUID ;的变量
        例如：static final long serialVersionUID = 42L;
        3.反序列化对象时，该对象的class必须存在，否则会报错，
        4.static变量无法被序列化
        5.被 transient 关键字修饰的成员变量 也不能 被序列化

 */
public class MyObjectStream implements Serializable {
}
