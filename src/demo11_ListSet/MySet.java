package demo11_ListSet;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Set接口实现了 Collection 接口
 *  1.无序集合
 *  2.没有索引
 *  3.元素不能重复
 *  4.底层实现为hash表，特点就是快
 *  5.不能使用普通for循环遍历
 *  实现类：HashSet
 *
 *  HashSet：
 *      1.底层实现：数组+链表/红黑树（当相同hashcode个数大于8时，将纵向链表结构，自动转换成红黑树）
 *      2.Set存储不重复元素的原理：首先计算hashcode，查找是否存在，不存在，直接加入；
 *          存在，则将添加的与现有的进行equals比较，返回true，认定元素存在，则不存入，否则存入。
 *  LinkedHashSet:
 *      1.与HashSet比较是多了一个用于存放存入顺序的链表，===有序
 */
public class MySet {
    public static void main(String[] args) {
        HashSet<String> set=new HashSet<>();
        set.add("123");
        set.add("123"); //已经存在，不会再存储
        set.forEach(System.out::println);

        //存储自定义数据类型,
        //名字相同，年龄相同，视为同一个对象
        HashSet<Student> students=new HashSet<>();
        students.add(new Student("斯凯",24));
        students.add(new Student("斯凯",24));
        students.add(new Student("斯凯",25));

        System.out.println(students);

        System.out.println("===========================================");

//        HashSet hashSet=new HashSet();  //[aaa, ccc]
        LinkedHashSet hashSet=new LinkedHashSet();  //[ccc, aaa]
        hashSet.add("ccc");
        hashSet.add("ccc");
        hashSet.add("aaa");

        System.out.println(hashSet);
    }
}
