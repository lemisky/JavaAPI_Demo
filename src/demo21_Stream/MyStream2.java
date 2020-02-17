package demo21_Stream;

import com.sun.jdi.event.StepEvent;

import java.util.*;
import java.util.stream.Stream;

/*
    获取stream的方式

    1.通过单列结合，Collection.stream()
    2.Stream接口的静态方法 of(T...)
 */
public class MyStream2 {
    public static void main(String[] args) {
        //单列集合获取Stream流
        //List
        List list=new ArrayList();
        Stream stream = list.stream();

        //Set
        Set set=new HashSet();
        Stream stream1 = set.stream();

        //双列集合间接获取
        Map<String ,String > map=new HashMap<>();

        Stream<String> stream2 = map.keySet().stream();
        Stream<String> stream3 = map.values().stream();
        Stream<Map.Entry<String, String>> stream4 = map.entrySet().stream();

        //数组获取stream流
        Stream<Integer> integerStream = Stream.of(2, 3, 4, 23, 4, 5,2 , 6, 2);
        int[] nArr=new int[]{34,23,12,43,21,43212,32};

        Stream<int[]> nArr1 = Stream.of(nArr);


    }
}
