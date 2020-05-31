import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //给定一组测试用例10个，接收输入，每个用例是
        //假设，接收的输入为：
        //4
        //3 1 10 31
        //hasNextXXX()和nextXXX()读取到io数据直到满足条件（空格和换行符），否则阻塞等待
        //io流只能操作一次，hasNextXXX()不操作，只判断。和nextXXX()读取一下，io流跑到下一个读取的位置
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                int data = sc.nextInt();
                System.out.println(data);
            }
        }
        //4
        //3 1 10 31
        while (sc.hasNextLine()) {
            String s = sc.nextLine();//4
            String next = sc.nextLine();//3 1 10 31
        }
    }
}
