package java0428;

import java.util.Scanner;

public class Interview {
//Fibonacci数列是这样定义的：
//F[0] = 0
//F[1] = 1
//for each i ≥ 2: F[i] = F[i-1] + F[i-2]
//因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。
// 给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，
// 现在给你一个数N求最少需要多少步可以变为Fibonacci数。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 0 ) {
            System.out.println(0);
            return;
        }
        //构造fibonacci数组
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        int flag = 0;
        for (int i = 2; i < n; i++) {
            fibonacci[i] =fibonacci[i - 1] + fibonacci[i - 2];
            if (fibonacci[i -1] <= n && fibonacci[i] > n) {
                flag = i;
                break;
            }
        }
        int min = n-fibonacci[flag-1] < fibonacci[flag] - n ? fibonacci[flag-1] : fibonacci[flag];
        System.out.println(Math.abs (n - min));
    }
}
