package eduxust.java;

//模板方法设计模式
public class TestTemplate {
	public static void main(String[] args) {
		new SubTemplate().spendTime();
	}
}

abstract class Template {

	public abstract void code();
//例如计算某一个算法使用的时间，算法并不确定，但是通用的计算时间的方法是确定的
	//将不确定的算法设置成一个抽象的，让子类去重写。
	public void spendTime() {
		long start = System.currentTimeMillis();

		this.code();

		long end = System.currentTimeMillis();
		System.out.println("花费的时间为：" + (end - start));
	}
}

class SubTemplate extends Template {
	
	//	子类必须重写抽象父类中的抽象方法，例如10000以内的素数
	public void code() {
		boolean flag = false;
			for(int i = 2;i <= 10000;i++){
			for(int j = 2;j <= Math.sqrt(i);j++){
				if(i % j == 0){
					flag = true;
					break;
				}
			}
			if(!flag){
				System.out.println(i);
			}
			flag = false;
		}
	}
}