package sort0429;

import java.util.Arrays;

public class MergeSortTest {
    //有序区间[low, mid)
    //有序区间[mid, high)
    //把两个有序区间合并成一个有序区间
    public static void merge (int[] array, int low, int mid ,int high) {
        int[] output = new int[high - low];
        int outputIndex = 0;//用来记录当前output数组中放入了多少个元素
        int cur1 = low;//第一个区间的下标
        int cur2 = mid;//第二个区间的下标
        while (cur1 < mid && cur2 < high) {
            if (cur1 <= cur2) {
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            }else {
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }
            //当上面的循环结束的时候,肯定是 cur1 或 cur2 有一个先到达末尾,另一个剩下一些内容
            //只需要将剩下的内容直接放到 output 中就可以了
            while (cur1 < mid) {
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            }
            while (cur2 < high) {
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }
            //把output中的元素搬运回原来的数组
            for (int i = 0; i < high - low; i++) {
                array[low + i] = output[i];
            }
        }
    }
    public static void mergeSort(int[] array) {
        mergeSortHelp(array, 0, array.length);
    }
//[low, high)两者之间的差值小于1,那么区间中就只要 0 个和 1 个元素
    private static void mergeSortHelp(int[] array, int low, int high) {
       if (high - low <= 1) {
           return;
       }
       int mid = (low + high) / 2;
       //这个方法执行完,就认为[low,mid)就是有序的了
       mergeSortHelp(array, low, mid);
       //这个方法执行完,就认为[mid,high)是有序的了
       mergeSortHelp(array, mid, high);
       //当把左右两个区间归并排序完,左右取件就是有序的区间了
        //接下来就是将两个有序区间进行合并
        merge(array, low, mid, high);
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
