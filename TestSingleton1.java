package eduxust.java;
//懒汉式:可能存在线程安全问题的
public class TestSingleton1 {
	public static void main(String[] args) {
		Singleton1 s1 = Singleton1.getInstance();
		Singleton1 s2 = Singleton1.getInstance();
		System.out.println(s1 == s2);
		
	}
}
class Singleton1{
	//1.私有化构造器，使得在类的外部不能够调用此构造器
	private Singleton1(){
		
	}
	//2.在类的内部创建一个类的实例，为空（你用的时候再创建）
	private static Singleton1 instance = null;
	//3.	私有化此对象，通过公共的方法来调用；只能通过类来调用，因为设置为static的,同时类的实例也必须为static声明的
	//在方法中先创建后返回（方法中有两项工作）
	public static Singleton1 getInstance(){
		
		if(instance == null){
			
			instance = new Singleton1();
		}
		return instance;
	}
	/**
	 *假如现在有两个线程A 和线程B，线程A 执行到 instance = new Singleton1();
	 *正在申请内存分配，可能需要0.001 微秒，
	 *就在这0.001 微秒之内，线程B 执行到if(instance == null)，
	 *你说这个时候这个判断条件是true 还是false？是true，那然后呢？
	 *线程B 也往下走，于是乎就在内存中就有两个Singleton 的实例了，看看是不是出问题了？
	 */
	//面试的时候如果写的话，建议写饿汉式的；或者写解决后的懒汉模式
}