package learn;
import java.util.Scanner;
public class Month{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int month = sc.nextInt();
            System.out.println(count(month));
        }
    }

    private static int count(int month){
        if (month == 1 || month == 2) {
            return 1;
        }
        return count(month - 1) + count(month - 2);
    }
}



//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int monthCount=sc.nextInt();
//            System.out.println(getTotalCount2(monthCount));
//
//        }
//    }
//    private static int getTotalCount2(int monthCount) {
//        if(monthCount==1||monthCount==2){
//            return 1;
//        }
//        //这里是倒着算的,不影响结果,因为算的次数是相同的
//        return getTotalCount2(monthCount-1)+getTotalCount2(monthCount-2);
//    }
//}