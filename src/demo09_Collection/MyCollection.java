package demo09_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合相关
 * Collection是一个单列集合接口
 * List接口：Vector、ArrayList、LinkedList  有序、可存放重放元素，有索引，可遍历
 * Set接口：TreeSet、HashSet（LinkedHashSet）    不允许存放重复元素
 * 关于集合的遍历：迭代器、增强的for循环
 */
public class MyCollection {
    public static void main(String[] args) {
        //使用多态定义集合
        //不指定泛型，默认元素类型为Objec
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("string");
        coll.add(true);

        //使用迭代器遍历
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //使用增强版的for循环
        for (Object o :
                coll) {
            System.out.println(o);
        }
    }
}
