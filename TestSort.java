package sort0410;

import java.util.Arrays;

public class TestSort {

    //插入排序（以升序为例）
    //时间复杂度：O(N ^ 2)  空间复杂度:O(1)  稳定性：稳定排序
    public static void insertSort(int[] array) {
        //通过bound来划分已排序区间和待排序区间
        //[0,bound)表示已排序区间
        //[bound,size)表示未排序区间
        for(int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1;//表示已排序区间的最后一个元素
            for ( ; cur >= 0; cur--) {
                //array[bound - 1]与array[bound]比较大小
                if(array[cur] > v) {
                    array[cur + 1] = array[cur];
                } else {
                    //此时说明已经找到了合适的位置
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }

    //排序

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
