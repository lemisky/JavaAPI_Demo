package demo13;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * JDK 9 在 List、Set、Map 集合中 中添加了 静态 of 方法
 * 方法返回对应类型的集合
 * 使用限制：
 * 1.集合该遵守的得遵守，否则抛异常
 * 2.返回的集合，不可更改
 *
 * 试用于 集合元素确定，一定行存入
 */
public class MyCollectionOf {
    public static void main(String[] args) {
        List list = List.of(1, 2, "a", "b");
//        list.add(123);  //错误：Exception in thread "main" java.lang.UnsupportedOperationException
//        list.remove(3); //Exception in thread "main" java.lang.UnsupportedOperationException
        System.out.println(list);

        Set set = Set.of(1, 2, "string", true);
        System.out.println(set);

        Map<String, String> map = Map.of("key1", "value1", "key2", "value2");
        System.out.println(map);

    }
}
