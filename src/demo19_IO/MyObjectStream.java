package demo19_IO;

import java.io.*;

/*
    对象流，又称之为序列化流，用于将对象打印到文件中

    序列化：
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
        6.当要序列化多个对象时，以集合的方法序列化和反序列化

    常用方法：
        writeObject();

    反序列化：
        ObjectInputStream
    java.lang.Object
      继承者 java.io.InputStream
          继承者 java.io.ObjectInputStream
    构造方法：
    ObjectInputStream(InputStream in)
          创建从指定 InputStream 读取的 ObjectInputStream。
    常用方法：
    readObject()
          从 ObjectInputStream 读取对象。


 */
public class MyObjectStream implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ww();
        rr();
    }

    private static void rr() throws IOException, ClassNotFoundException {
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/demo19_IO/序列化.txt"));
        Object o = ois.readObject();
        System.out.println(o);
        ois.close();
    }

    private static void ww() throws IOException {
        //序列化
        Student ss = new Student(21, "肖");
        System.out.println(ss);
        //创建序列化对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/demo19_IO/序列化.txt"));
        oos.writeObject(ss);
        oos.close();
    }
}

class Student implements Serializable {
    static final long serialVersionUID = 111L;
    private transient int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
