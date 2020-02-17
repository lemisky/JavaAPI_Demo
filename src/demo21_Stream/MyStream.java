package demo21_Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
    Stream 流式编程 入门小示例
 */
public class MyStream {
    public static void main(String[] args) {
        List<String> list=new ArrayList();
        list.add("齐云霄");
        list.add("马良");
        list.add("元瑶");
        list.add("南宫婉");
        list.add("银月");
        list.add("珑梦");
        list.add("紫灵仙子");
        list.add("厉飞雨");
        list.add("张铁");
        list.add("墨大夫");
        list.add("李化元");
        list.add("陈巧倩");
        list.add("菡云芝");
        list.add("董萱儿");
        list.add("玄骨上人");
        list.add("极阴祖师");
        list.add("文思月");

        list.stream().filter(s->s.length()>3).forEach(System.out::println);
        //紫灵仙子
        //玄骨上人
        //极阴祖师
    }
}
