package eduxust.java;
//�ӿڵ�Ӧ�ã��������������ģʽ
public class TestFactoryMethod {
	public static void main(String[] args) {
		IWorkFactory i = new StudentWorkFactory();
		i.getWork().doWork();
		
		IWorkFactory i1 = new TeacherWorkFactory();
		i1.getWork().doWork();
	}
}

/*IWorkFactory�ӿ��Լ�����ʵ����*/
interface IWorkFactory{
	Work getWork();//����ֵΪWork�ķ���
}
class StudentWorkFactory implements IWorkFactory{

	@Override
	public Work getWork() {
		return new StudentWork();
	}
	
}
class TeacherWorkFactory implements IWorkFactory{

	@Override
	public Work getWork() {
		return new TeacherWork();
	}
	
}
/*Work�ӿ��Լ�����ʵ����*/
interface Work{
	void doWork();
}

class StudentWork implements Work{

	@Override
	public void doWork() {
		System.out.println("ѧ��д��ҵ");
	}
	
}
class TeacherWork implements Work{

	@Override
	public void doWork() {
		System.out.println("��ʦ������ҵ");
	}
	
}
