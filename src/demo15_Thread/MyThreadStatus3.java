package demo15_Thread;

/**
 * waiting() 方法,效果与 sleep() 差不多
 */
public class MyThreadStatus3 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (this) {
                    System.out.println("正在生产。。");
                    try {
                        this.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("包子做好了");
                }


            }
        }).start();
    }
}
