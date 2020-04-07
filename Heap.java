package Heap0407;

public class Heap {

    //以小堆为例

    //index代表要调整的元素的下标
    //size代表数组中被视为堆数据的个数
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
}
