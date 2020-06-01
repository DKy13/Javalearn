package eduxust.java;

//ģ�巽�����ģʽ
public class TestTemplate {
	public static void main(String[] args) {
		new SubTemplate().spendTime();
	}
}

abstract class Template {

	public abstract void code();
//�������ĳһ���㷨ʹ�õ�ʱ�䣬�㷨����ȷ��������ͨ�õļ���ʱ��ķ�����ȷ����
	//����ȷ�����㷨���ó�һ������ģ�������ȥ��д��
	public void spendTime() {
		long start = System.currentTimeMillis();

		this.code();

		long end = System.currentTimeMillis();
		System.out.println("���ѵ�ʱ��Ϊ��" + (end - start));
	}
}

class SubTemplate extends Template {
	
	//	���������д�������еĳ��󷽷�������10000���ڵ�����
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