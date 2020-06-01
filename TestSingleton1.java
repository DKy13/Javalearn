package eduxust.java;
//����ʽ:���ܴ����̰߳�ȫ�����
public class TestSingleton1 {
	public static void main(String[] args) {
		Singleton1 s1 = Singleton1.getInstance();
		Singleton1 s2 = Singleton1.getInstance();
		System.out.println(s1 == s2);
		
	}
}
class Singleton1{
	//1.˽�л���������ʹ��������ⲿ���ܹ����ô˹�����
	private Singleton1(){
		
	}
	//2.������ڲ�����һ�����ʵ����Ϊ�գ����õ�ʱ���ٴ�����
	private static Singleton1 instance = null;
	//3.	˽�л��˶���ͨ�������ķ��������ã�ֻ��ͨ���������ã���Ϊ����Ϊstatic��,ͬʱ���ʵ��Ҳ����Ϊstatic������
	//�ڷ������ȴ����󷵻أ����������������
	public static Singleton1 getInstance(){
		
		if(instance == null){
			
			instance = new Singleton1();
		}
		return instance;
	}
	/**
	 *���������������߳�A ���߳�B���߳�A ִ�е� instance = new Singleton1();
	 *���������ڴ���䣬������Ҫ0.001 ΢�룬
	 *������0.001 ΢��֮�ڣ��߳�B ִ�е�if(instance == null)��
	 *��˵���ʱ������ж�������true ����false����true����Ȼ���أ�
	 *�߳�B Ҳ�����ߣ����Ǻ������ڴ��о�������Singleton ��ʵ���ˣ������ǲ��ǳ������ˣ�
	 */
	//���Ե�ʱ�����д�Ļ�������д����ʽ�ģ�����д����������ģʽ
}