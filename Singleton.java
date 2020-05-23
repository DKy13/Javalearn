package lesson5;

//单例:在某些场景下,需要获取同一个对象
//类加载在JVM内部执行,保证了线程间同步互斥的:
//(1)只执行一次   (2)线程安全
public class Singleton {

    //饿汉式:在类加载的时候,就创建对象
    public static Singleton SINGLETON = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SINGLETON;
    }


    //懒汉式:
    public static Singleton SINGLETON2;

    //省略了构造方法

    //懒汉式的写法存在多线程安全问题
    public static Singleton getInstance2() {
        if (SINGLETON2 == null) {
            SINGLETON2 = new Singleton();//分解为三条指令
            //1)分配对象的空间
            //2)初始化对象
            //3)对象赋值给变量(对象引用)
        }
        return SINGLETON2;
    }


    //重点******
    //双重校验锁的单例模式
    public static Singleton SINGLETON3;

    //省略了构造方法

    public static Singleton getInstance3() {
        if (SINGLETON3 == null) {
            synchronized (Singleton.class) {
                if (SINGLETON3 == null) {
                    SINGLETON3 = new Singleton();
                }
            }
        }
        return SINGLETON3;
    }
}
