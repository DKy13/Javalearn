package learn;

import java.util.Arrays;
//数组中出现次数超过一半的数字---牛客网

public class MoreThanHalfNum {
    public  static int MoreThanHalfNum_Solution(int [] array) {
        if(array == null) {
            return 0;
        }
        Arrays.sort(array);
        int count = 0;
        int target = array[array.length / 2];
        for (int i = 0; i < array.length;i++) {
            if(target == array[i]) {
                count++;
            }
        }
        if(count > array.length / 2) {
            return target;
        }
        return 0;
    }

    public static void main(String[] args) {
        int [] arr ={1,2,3,2,2,2,5,4,2};
        int out = MoreThanHalfNum_Solution(arr);
        System.out.println(out);
    }
}
