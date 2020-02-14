package demo15_Thread;

/**
 * 线程安全问题解决方案之 同步方法
 */
public class MyThread4 {
    public static void main(String[] args) {
        //创建线程任务
        MyRunnable3 runnable = new MyRunnable3();
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

class MyRunnable3 implements Runnable {
    //卖票，提供多个进程共享的数据源
    private static int i = 100;
//    private Object obj = new Object();

    @Override
    public void run() {
        while (i > 0) {
            //同步方法
//            payTicket();
//            spayTicket();
            sspayTicket();
        }
    }

    //成员同步方法，锁对象：this
    private synchronized void payTicket() {
        if (i > 0) {
            System.out.println(Thread.currentThread().getName() + " 正在卖 第" + i-- + "张 票~");
        }
    }

    //静态同步方法，锁对象：本类的class属性，class文件对象
    private static synchronized void spayTicket() {
        if (i > 0) {
            System.out.println(Thread.currentThread().getName() + " 正在卖 第" + i-- + "张 票~");
        }
    }

    //静态同步方法，锁对象：本类的class属性，class文件对象
    private static /*synchronized*/ void sspayTicket() {
        synchronized (MyRunnable3.class) {
            if (i > 0) {
                System.out.println(Thread.currentThread().getName() + " 正在卖 第" + i-- + "张 票~");
            }
        }
    }

}