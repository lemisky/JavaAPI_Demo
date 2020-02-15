package demo16_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 1.在JDK1.5之前，线程池都是通过手动模拟的，
 * 即通过集合存储Thread示例，需要时remove(0)出来调用，用完后add()进去
 * 2.现在JDK提供了专门的线程池，java.util.concurrent.Executors
 * 继承了java.util.concurrent  * 接口 ExecutorService
 * <p>
 * 使用步骤，
 * 1.调用Executors类的静态方法 newFixedThreadPool，返回ExecutorService接口实现类的实例
 * 创建一个可重用固定线程集合的线程池，以共享的无界队列方式来运行这些线程。
 * 2.调用ExecutorService接口实现类的实例的submit(Runnable)来使用
 * 3.使用完成后 shutdown() 销毁线程池
 */
public class MyThreadPool {
    public static void main(String[] args) throws Exception {
        //
        ExecutorService tpools = Executors.newFixedThreadPool(4);
        //
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        tpools.submit(runnable);    //pool-1-thread-2
        tpools.submit(runnable);    //pool-1-thread-4
        tpools.submit(runnable);    //pool-1-thread-3
        tpools.submit(runnable);    //pool-1-thread-1
        tpools.submit(runnable);    //pool-1-thread-2
        tpools.submit(runnable);    //pool-1-thread-4
        tpools.submit(runnable);    //pool-1-thread-2
        //关闭
        tpools.shutdown();
    }

}
