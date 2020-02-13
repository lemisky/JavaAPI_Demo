package demo13;

import java.util.HashMap;
import java.util.Set;

/**
 * Map集合
 * 双列集合（相对于Collection的单列）
 * key-value
 * 1.key必须唯一，value可以重复
 * 2.由于底层使用hash表实现，所以key和value碧玺为Object类型，换句话说，就是key和value不能时基本数据类型
 * 实现类：HashMap<K,V>
 * 无序集合，不同步，多线程，速度快，线程不安全
 * 1.底层hash表，查询速度快，数组+链表/红黑树（链表长度大于8时使用红黑树）
 * 2.无序，输入与输出顺序可能不一致。
 *
 * LinkedHashMap：多了一个链表，保证迭代的顺序
 */
public class MyMap {
    public static void main(String[] args) {
        //1.key-value不允许是基本数据类型
        HashMap<String, Integer> map = new HashMap<>();
        //2.使用put()向Map中添加数据
        //  当存入的值不存在，即put的是一个新值时，返回为null
        //  即返回 put() 函数返回的是被替换的value，
        System.out.println(map.put("key", 555));    //null
        //3.使用get()在Map中取数据
        //4.这里的接收数据类型 Integer 可以是 int（自动拆箱）
        //  * 但是在所取key不存在时，则会返回 null,这时使用 int 类型来接收则会报错——null类型无法转为int类型
        Integer n = map.get("key");
        System.out.println(n);  //555
        //5.当key不存在时，返回null
        System.out.println(map.get("name"));    //null
        //6.使用size()函数获取map大小
        System.out.println(map.size()); //1
        //7.使用remove()函数，移除某个元素
        //  当元素不存在时，返回null，否则返回被移除的 value
        System.out.println(map.remove("key"));  //555
        System.out.println(map);    //{}
        //=================================
        map.put("1",1);
        map.put("2",2);
        map.put("3",1);
        //8.遍历
        //  1.使用，keySet()获取key的集合
        //  2.使用增强版的for循环
        Set<String> keys = map.keySet();
        for (String key :
                keys) {
            System.out.println(key+":"+map.get(key));
            //1:1
            //2:2
            //3:1
        }
    }
}
