package demo17_lambda;

import java.util.Arrays;

/**
 * lambda表达式
 * 函数式接口：只有一个抽象方法的接口
 * 函数式编程：使用函数式接口简化代码
 * 背景说明：面向对象编程太过强调谁去完成，而有时我们只关心怎么完成。。
 */
public class MyLambda {
    public static void main(String[] args) {
        //格式：
        //  (参数列表)->{方法体}
        //lambda表达式省略模式
        //1.参数类型可省略不写
        //2.当只有一个参数时，小括号可以省略
        //3.当代码只有一行时，花括号、分号、return 等（需一起）可省略

        //Runnable接口，只有一个抽象方法，所有可以使用lambda表达式
        //普通使用方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        //lambda表达式,标准形式
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
        //lambda简写形式
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

        //多参数，带返回值的函数式接口
        Student[] students = new Student[]{
                new Student(1, "韩立"),
                new Student(2, "韩信"),
                new Student(0, "hello"),
        };

        System.out.println(Arrays.toString(students));
        //正常用法
//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getNo()-o2.getNo();
//            }
//        });

        //lambda
        Arrays.sort(students, (o1, o2) ->
                o1.getNo() - o2.getNo()
        );
        System.out.println(Arrays.toString(students));

    }
}

class Student {
    private int no;
    private String name;

    public int getNo() {
        return no;
    }

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
