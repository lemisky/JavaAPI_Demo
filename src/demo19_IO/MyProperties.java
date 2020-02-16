package demo19_IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

/**
 * Properties   配置文件类
 * java.util  * 类 Properties extends Hashtable extends Map
 * 构造方法：
 * Properties()
 * 创建一个无默认值的空属性列表。
 * 常用方法：
 * String getProperty(String key)
 * 用指定的键在此属性列表中搜索属性。
 * String getProperty(String key, String defaultValue)
 * 用指定的键在属性列表中搜索属性。
 * load(InputStream inStream)
 * 从输入流中读取属性列表（键和元素对）。
 * propertyNames()
 * 返回属性列表中所有键的枚举，如果在主属性列表中未找到同名的键，则包括默认属性列表中不同的键。
 * stringPropertyNames()
 * ...
 * setProperty(String key, String value)
 * 调用 Hashtable 的方法 put。
 * store(OutputStream out, String comments)
 * 以适合使用 load 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。
 * <p>
 * 使用步骤：
 * 1.创建properties对象
 * 2.setProperty()设置属性值
 * 3.使用propertyNames()遍历
 * 4.store()存储文件
 * 5.load()从文件加载
 */
public class MyProperties {

    public static void main(String[] args) throws IOException {
//        p1();
        p2();
    }

    private static void p2() throws IOException {
        //1.创建properties对象
        Properties pro = new Properties();
        //2.加载
        pro.load(new FileReader("src/demo19_IO/pro.txt"));
        //3.遍历
        pro.stringPropertyNames().forEach(s -> System.out.println(s + ":" + pro.getProperty(s)));
    }

    private static void p1() throws IOException {
        //1.创建properties对象
        Properties pro = new Properties();
        //2.设置属性值
        pro.setProperty("name", "java配置文件");
        pro.setProperty("width", "400");
        pro.setProperty("hight", "300");
        //3.遍历
        //使用stringPropertyNames()方法
//        for (String s : pro.stringPropertyNames()) {
//            System.out.println(s+":"+pro.getProperty(s));
//        }
        //使用迭代器
        Iterator<?> iterator = pro.propertyNames().asIterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next + ":" + pro.get(next));
        }
        //4.存储
        pro.store(new FileWriter("src/demo19_IO/pro.txt"), "comments");
    }
}
