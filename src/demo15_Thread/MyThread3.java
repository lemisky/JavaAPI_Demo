package demo15_Thread;

/**
 * 线程安全问题解决方案之 同步代码块
 */
public class MyThread3 {
    public static void main(String[] args) {
        //创建线程任务
        MyRunnable2 runnable = new MyRunnable2();
        //创建三个进程——对应3个买票窗口
        Thread thread1 = new Thread(runnable, "一号窗口");
        Thread thread2 = new Thread(runnable, "二号窗口");
        Thread thread3 = new Thread(runnable, "三号窗口");
        //开始买票
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class MyRunnable2 implements Runnable {
    //卖票，提供多个进程共享的数据源
    private int i = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (i > 0) {
            //同步代码块
            synchronized (obj) {
                if (i > 0) {
                    System.out.println(Thread.currentThread().getName() + " 正在卖 第" + i-- + "张 票~");
                }
            }
        }
    }
}