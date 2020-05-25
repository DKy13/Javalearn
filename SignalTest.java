package lesson6;


import lesson5.Singleton;

//假设面包师傅有5个,可以一直生产面包,每次生产3个
//假设消费者有20个,可以一直消费面包,每次生产1个
//面包库存的上限是100,下限为0
public class SignalTest {

    //库存
    private  static int SUM;

    public static void main(String[] args) {
        //5个面包师傅,同时启动
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (SignalTest.class) {
                            if (SUM > 100) {
                                SignalTest.class.wait();
                            }else {
                                SUM += 3;
                                System.out.println(Thread.currentThread().getName() +"生产了面包,库存:" + SUM);
                                SignalTest.class.notifyAll();
                            }
                        }
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"面包师傅["+ i +"]").start();
        }
        //20个消费者,同时启动
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (SignalTest.class) {
                            if (SUM == 0) {
                                SignalTest.class.wait();
                            }else {
                                SUM--;
                                System.out.println(Thread.currentThread().getName() +"消费了面包,库存:" + SUM);
                                SignalTest.class.notifyAll();
                            }
                        }
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"消费者["+ i +"]").start();
        }
    }
}
