package demo15_Thread;

/**
 * 线程安全问题测试
 */
public class MyThread2 {
    public static void main(String[] args) {
        //创建线程任务
        MyRunnable runnable = new MyRunnable();
        //创建三个进程——对应3个买票窗口
        Thread thread1 = new Thread(runnable, "一号窗口");
        Thread thread2 = new Thread(runnable, "二号窗口");
        Thread thread3 = new Thread(runnable, "三号窗口");
        //开始买票
        thread1.start();
        thread2.start();
        thread3.start();

        //输出如下：
        //一号窗口 正在卖 第99张 票~
        //三号窗口 正在卖 第100张 票~
        //二号窗口 正在卖 第100张 票~
        //二号窗口 正在卖 第98张 票~
        //三号窗口 正在卖 第98张 票~
        //一号窗口 正在卖 第98张 票~
        //三号窗口 正在卖 第97张 票~
        //二号窗口 正在卖 第97张 票~
        //一号窗口 正在卖 第97张 票~

        /**
         * 这就是线程安全问题
         *  产生线程安全问题的原因：多个线程同时访问了共享数据
         *
         *  //多线程线程安全（同步）问题的解决方式
         *         //1.同步代码块
         *         //2.同步函数
         *         //3.锁对象
         */


    }
}

class MyRunnable implements Runnable {
    //买票，提供多个进程共享的数据源
    private int i = 100;

    @Override
    public void run() {
        while (i > 0) {
            //执行一些操作，耗时较长
            //使用sleep来模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 正在卖 第" + i-- + "张 票~");
        }
    }
}