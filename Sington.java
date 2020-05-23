package lesson5;

//单例:在某些场景下,需要获取同一个对象
//类加载在JVM内部执行,保证了线程间同步互斥的:
//(1)只执行一次   (2)线程安全
public class Sington {

    //饿汉式:在类加载的时候,就创建对象
    public static Sington SINGTON = new Sington();

    private Sington() {
    }

    public static Sington getInstance() {
        return SINGTON;
    }


    //懒汉式:
    public static Sington SINGTON2;

    //省略了构造方法

    //懒汉式的写法存在多线程安全问题
    public static Sington getInstance2() {
        if (SINGTON2 == null) {
            SINGTON2 = new Sington();//分解为三条指令
            //1)分配对象的空间
            //2)初始化对象
            //3)对象赋值给变量(对象引用)
        }
        return SINGTON2;
    }


    //重点******
    //双重校验锁的单例模式
    public static Sington SINGTON3;

    //省略了构造方法

    public static Sington getInstance3() {
        if (SINGTON3 == null) {
            synchronized (Sington.class) {
                if (SINGTON3 == null) {
                    SINGTON3 = new Sington();
                }
            }
        }
        return SINGTON3;
    }
}
