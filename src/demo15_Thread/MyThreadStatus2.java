package demo15_Thread;

/**
 * 线程锁问题：
 * 线程通过锁对象调用 wait() 方法来进行等待，
 * 通过锁对象的  notifyAll() 方法进行唤醒全部等待线程
 */
public class MyThreadStatus2 {
    public static void main(String[] args) {
        //定义一个锁对象
        Object obj = new Object();
        //生产者与消费者
        //消费者1
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj){
                        System.out.println("消费者1需要产品。。");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("消费者1得到产品");
                    }
                }
            }
        }).start();
        //消费者2
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj){
                        System.out.println("消费者2需要产品。。");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("消费者2得到产品");
                    }
                }
            }
        }).start();

        //生产者
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj) {
                        System.out.println("包子生产好了。。");
                        //notify()只能随机唤醒一个线程
//                        obj.notify();
                        obj.notifyAll();
                    }
                }
            }
        }).start();

    }
}
