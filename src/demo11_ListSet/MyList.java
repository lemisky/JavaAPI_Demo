package demo11_ListSet;

import java.util.LinkedList;

/**
 * List集合：ArrayList 底层由数组实现：查找快，增删慢
 *          LinkedList  底层链表原理：查找慢，增删快
 */
public class MyList {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList();
        list.push("Hello World");
        list.push("123");
        list.forEach(System.out::println);
        list.pop();
        list.forEach(System.out::println);
    }
}
