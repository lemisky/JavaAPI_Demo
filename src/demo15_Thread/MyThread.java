package demo15_Thread;

/**
 * 并发：一段时间内执行多个任务。并发交替执行
 * 并行：同一时刻执行多个任务。并行同时执行
 *
 * 进程：从硬盘加载到内存中执行的应用程序，一个进程可以包含多个线程。
 * 线程：进程执行任务的单元，由进程创建
 *
 * 线程调度：
 *  1.分时调度：所有线程平均分配CPU运行
 *  2.抢占式调度：优先让优先级高的线程运行，java属于抢占式调度。
 *      在Windows系统中，可以通过任务管理器来进行设置
 *
 *  创建线程的方式：
 *      1.继承Thread
 *      2.实现Runnable：
 *      区别：1.使用Runnable创建线程，避免了java单继承的问题
 *           2.增强了程序的扩展性，把设置线程任务与线程开启进行了分离
 */
public class MyThread {
    public static void main(String[] args) {
        //获取当前线程名称
        System.out.println(Thread.currentThread().getName());   //main
        System.out.println(Thread.currentThread().getId());     //1

        new Thread(){
            @Override
            public void run() {
                super.run();
//                for (int i = 0; i < 10000; i++) {
//                    System.out.println("thread===?"+i);
//                }
                System.out.println(getName());  //Thread-0
                System.out.println(getId());    //14
            }
        }.start();

        new Thread("MyThread"){
            @Override
            public void run() {
                super.run();
                System.out.println(getName());  //MyThread
                System.out.println(getId());    //15
                setName("Hello World");
                System.out.println(getName());  //Hello World
            }
        }.start();

        //主线程结束后，子线程仍然会继续执行
        //当进程中的所有线程都结束时进程才会结束退出
        //执行System.exit(0)，所有线程会终止，进程结束。

        //使用Runnable
        //lambda表达式
//        new Thread(()->{
//            //代码
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());   //自定义线程
            }
        },"自定义线程").start();
    }
}
