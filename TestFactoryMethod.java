package eduxust.java;
//接口的应用：工厂方法的设计模式
public class TestFactoryMethod {
	public static void main(String[] args) {
		IWorkFactory i = new StudentWorkFactory();
		i.getWork().doWork();
		
		IWorkFactory i1 = new TeacherWorkFactory();
		i1.getWork().doWork();
	}
}

/*IWorkFactory接口以及它的实现类*/
interface IWorkFactory{
	Work getWork();//返回值为Work的方法
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
/*Work接口以及它的实现类*/
interface Work{
	void doWork();
}

class StudentWork implements Work{

	@Override
	public void doWork() {
		System.out.println("学生写作业");
	}
	
}
class TeacherWork implements Work{

	@Override
	public void doWork() {
		System.out.println("老师批改作业");
	}
	
}
