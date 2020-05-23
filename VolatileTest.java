package lesson5;

public class VolatileTest {

    private static volatile int SUM;
    //volatile 作用:
    //1.保证可见性:变量都是从主存进行操作
    //2.禁止指令重排序,建立内存屏障
    //注意事项:不保证原子性
    public static void increment(int n) {
        //分解为三条指令:
        //1.从主内存读取到工作内存
        //2.在工作内存中修改SUM的值为 SUM+1
        //3.写回主内存
        SUM++;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() ->{
                for (int j = 0; j < 10000; j++) {
                   increment(j);
                }
            } ).start();
        }
        //所有子线程执行完毕后,打印SUM的值
        while (Thread.activeCount() > 1)//IDEA使用debug运行,run方法运行的话,要改为>2
            Thread.yield();//当前线程由运行态转变为就绪态
        System.out.println(SUM);
    }
}
