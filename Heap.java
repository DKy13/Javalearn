package Heap0407;

import java.util.Arrays;

public class Heap {

    //以小堆为例

    //index代表要调整的元素的下标
    //size代表数组中被视为堆数据的个数
    //向下调整应该从后往前遍历， 相反，向上调整应该从前往后遍历
    public static void shiftDown(int[] array, int size, int index){
        int left = 2 * index + 1;
        //保证数组不会越界
        while (left < size) {
            int min = left;
            int right = left + 1;
            if(right < size) {
                if(array[right] < array[left]) {
                    min = right;
                }
            }
            //经过上面的操作，min保存的肯定是left和right里面较小的那个元素的值

            
            //如果满足小堆的性质，结束
           if(array[index] <= array[min]) {
               break;
           }
           int tem = array[index];
           array[index] = array [min];
           array[min] = tem;
           //因为上面的调整，可能会破坏小堆的性质
            // 故而将min视为index，重复上面的操作
           index = min;
           left = 2 * index + 1;
        }
    }
    public static void creatHeap(int[]array, int size) {
        //size - 1表示的是最后一个叶子节点，再减1除2就得到了最后一个叶子节点的父节点（也就是最后一个非叶子节点）
        for(int i = (size - 1 -1) / 2; i >= 0; i--) {
            shiftDown(array, size,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
//        int[] array = {1,6,3,8,2,9,4,0};
        creatHeap(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
