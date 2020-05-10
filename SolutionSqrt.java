package learn0510;

import java.util.Scanner;

public class SolutionSqrt {
    //求 x 的平方根
//    计算并返回 x 的平方根，其中 x 是非负整数。
//    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去.
    //1.利用二分查找进行求解
    public static int mySqrt(int x) {
        //如果这个数小于0,直接返回0表示不存在
        //如果等于0,也返回0
        if (x < 1) {
            return 0;
        }else if (x == 1) {
            return 1;
        }
        //大于等于2的数只保留平方根的整数部分都是小于等于 x 的一半
        int left = 2;
        int right = x / 2;
        while (left <= right) {
            //定义遍历区间的中间位置
            int mid = left + (right - left) / 2;
            //用long 得到 mid 的平方 ,防止溢出
            long square = (long) mid * mid;
            if (square > x) {
                //说明x 的平方根比mid要小,缩小遍历区间的右边界 (实际遍历区间是在变小的)
                right = mid - 1;
            }else if (square < x) {
                //说明x 的平方根比mid要大,增大遍历区间的左边界 (实际遍历区间是在变小的)
                left = mid + 1;
            }else {
                return mid;
            }
        }//while
        return right;
    }//mySqrt

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ret = sc.nextInt();
        System.out.println(mySqrt(ret));
    }
}


