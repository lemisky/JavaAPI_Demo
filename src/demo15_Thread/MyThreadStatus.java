package demo15_Thread;

/**
 * 线程锁问题：
 * 线程通过锁对象调用 wait() 方法来进行等待，
 * 通过锁对象的  notify() 方法进行唤醒
 */
public class MyThreadStatus {
    public static void main(String[] args) {
        //定义一个锁对象
        Object obj = new Object();
        //生产者与消费者
        //消费者
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("消费者需要产品。。");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("消费者得到产品");
                }
            }
        }).start();

        //消费者
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {
                    System.out.println("包子生产好了。。");
                    //notify()只能随机唤醒一个线程
                    obj.notify();
                }
            }
        }).start();

    }
}
