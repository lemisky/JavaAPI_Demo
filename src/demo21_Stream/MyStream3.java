package demo21_Stream;

import java.util.stream.Stream;

/*
    延迟方法：返回值依旧是Stream，可以使用链式编程
    终结方法：返回值不是Stream

    注意事项：
        1.stream流只能使用一次，所以一般不定义变量，直接链式书写
 */
public class MyStream3 {
    public static void main(String[] args) {
        //常用方法
        //1.过滤filter，过滤集合中的元素
        //2.映射map，将集合中的元素类型映射成其他类型，并返回新的Stream
        //3.统计个数，count
        //4.截取元素，limit，取前几个
        //5.跳过面几个，skip
        //6.concat组合流


        Stream<String> stream = Stream.of("1", "2");
        System.out.println(stream.count());
//        stream.forEach(s-> System.out.println(s));  //会报错，因为上面已经使用过了
        //截取前面4个
        Stream.of(1,2,3,4,5,6,7).limit(4).forEach(s-> System.out.println(s));

    }
}
