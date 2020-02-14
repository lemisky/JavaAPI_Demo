package demo15_Thread;

/**
 * 等待唤醒机制测试 循环
 */
public class MyThreadStatus4 {
    public static void main(String[] args) {
        //创建锁对象
        Product product = new Product();
        //消费者
        //首先消费者提出需求——产品
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    //保证对象锁同时只有一个线程访问
                    synchronized (product){
                        if(!product.isHas()){
                            System.out.println("消费者://没有产品，则等待");
                            try {
                                product.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("消费者://被唤醒后消费产品");
                        //重设状态，并唤醒生产者
                        product.setHas(false);
                        product.notify();
                    }

                }
            }
        }).start();

        //生产者
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (product){
                        if(product.isHas()){
                            System.out.println("生产者://有产品，则等待");
                            try {
                                product.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("生产者://被唤醒后生产");
                        //重设状态，并唤醒消费者
                        product.setHas(true);
                        product.notify();
                    }
                }
            }
        }).start();
    }
}

//锁对象   Product
class Product {
    private boolean has = false;

    public boolean isHas() {
        return has;
    }

    public void setHas(boolean has) {
        this.has = has;
    }
}
