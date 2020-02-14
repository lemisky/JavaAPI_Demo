package demo15_Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全问题解决方案之 Lock锁
 * java.util.concurrent.locks 接口 Lock
 * 其实现类 java.util.concurrent.locks.ReentrantLock
 *
 * 使用步骤：
 *  1.创建Lock实现类对象
 *  2.在需要同步的地方，调用lock()方法
 *  3.在结束位置，调用unlock()方法
 */
public class MyThread5 {
    public static void main(String[] args) {
        //创建线程任务
        MyRunnable4 runnable = new MyRunnable4();
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

class MyRunnable4 implements Runnable {
    //卖票，提供多个进程共享的数据源
    private int i = 100;
//    private Object obj = new Object();
    Lock l=new ReentrantLock();

    @Override
    public void run() {
        while (i > 0) {
            //Lock锁，JDK1.5
            try {
                //开始结束位置调用lock
                l.lock();
                Thread.sleep(100);
                if (i > 0) {
                    System.out.println(Thread.currentThread().getName() + " 正在卖 第" + i-- + "张 票~");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                //同步结束位置
                l.unlock();
            }
        }
    }


}