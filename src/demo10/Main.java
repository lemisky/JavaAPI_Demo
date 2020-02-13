package demo10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 泛型数据
 */
public class Main {
    public static void main(String[] args) {
        MyGeneric generic=new MyGeneric();
        generic.setE(122);
        System.out.println(generic.getE());

        MyGeneric<String> stringMyGeneric=new MyGeneric<>();
        stringMyGeneric.setE("指定泛型后只能使用指定类型");
        System.out.println(stringMyGeneric.getE());

        System.out.println("=================================");
        MyGenericMethod method = new MyGenericMethod();
        method.m(new Object());
        System.out.println("=================================");

        //泛型通配符 ?

        ArrayList<Integer> list01=new ArrayList();
        list01.add(1);
        list01.add(2);
        list01.add(3);
        printList(list01);
        ArrayList<String> list02=new ArrayList<String>();
        list02.add("22");
        list02.add("224");
        list02.add("44");
        printList(list02);

        //此时会报错，因为 Integer 不是 String的本身，也不是String 类的子类
//        printList2(list01);
        printList2(list02);
    }
        //泛型通配符 ? 可以省略
//    static void printList(ArrayList arrayList){
    static void printList(ArrayList<?> arrayList){
        Iterator<?> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    static void printList2(ArrayList<? extends String> arrayList){
        Iterator<?> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
