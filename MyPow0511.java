package learn0510;

public class MyPow0511 {
    //    实现 pow(x, n) ，即计算 x 的 n 次幂函数。

    //1.递归分而治之
//    public static double myPowHelper(double x, long n) {
//        if (n == 1) {
//            return x;
//        }
//        if (n % 2 != 0) {
//            double half = myPowHelper(x, n / 2);
//            return half * half * x;
//        } else {
//            double half = myPowHelper(x, n / 2);
//            return half * half;
//        }
//    }
//
//    public static double myPow(double x, int n) {
//        if (n == 0 || x == 1) {
//            return 1;
//        }
//        if (n < 0) {
//            double y = 1 / myPowHelper(x, abs(n));
//            return y;//abs()求绝对值
//        }
//        return myPowHelper(x, n);
//    }

    //2.暴力解法
    public double myPow(double x, int n) {
        //将 n 变为长整型 N ,以用于处理负数越界
        long  N = n;
        if (N < 0) {
            x = 1 / x;
            N = - N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++) {
            ans = ans * x;
        }
        return ans;
    }
}