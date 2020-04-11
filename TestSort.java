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
            int v = array[bound];//表示无序区间的第一个数
            int cur = bound - 1;//表示已排序区间的最后一个元素
            for ( ; cur >= 0; cur--) {
                //array[bound - 1]与array[bound]比较大小
                //注意：此处如果改为array[cur] >= v,插入排序就不是稳定排序了
                if(array[cur] > v) {
                    array[cur + 1] = array[cur];
                } else {
                    //此时说明已经找到了合适的位置
                    break;
                }
            }
            array[cur + 1] = v;//表示将v挪到下一个无序区间中未排序的元素
        }
    }

    //希尔排序
    //时间复杂度：理论极限情况：O（N^1.3），如果是按照size / 2  、size / 4 ...... 的情况那就是O(N^2)
    //空间复杂度：O(1)
    //不是稳定性排序
public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            //需要循环进行分组插排
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        //当gap = 1的时候，也就是只有一组的时候
            insertSortGap(array, 1);
    }

    private static void insertSortGap(int[] array, int gap) {
        //通过bound来划分已排序区间和待排序区间
        //[0,bound)表示已排序区间
        //[bound,size)表示未排序区间
        for(int bound = gap; bound < array.length; bound++) {//循环处理所有组
            int v = array[bound];
            //同组元素之间的下表差值就是gap
            int cur = bound - gap;//在找同组元素中的上一个元素
            for ( ; cur >= 0; cur-= gap) {//只是处理当前组的插入和排序
                //array[bound - gap]与array[bound]比较大小
                //注意：此处如果改为array[cur] >= v,插入排序就不是稳定排序了
                if(array[cur] > v) {
                    array[cur + 1] = array[cur];
                } else {
                    //此时说明已经找到了合适的位置
                    break;
                }
            }
            array[cur + gap] = v;
        }
    }

    //选择排序
    //时间复杂度：O(N^2)
    //空间复杂度：O(1)
    //不稳定排序
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {//外层循环表示进行array.length - 1 趟
            //以bound元素为擂主，循环将待排序区间元素取出来与擂主进行比较
            //若是比擂主小，则打擂成功，交换位置
            //因为bound位置已经是擂主了，所以从bound + 1开始
            for (int cur =bound + 1; cur < array.length; cur++) {
                if(array[cur] < array[bound]) {
                    //打擂成功，进行交换
                    int tmp = array [bound];
                    array [bound] = array[cur];
                    array[cur] = tmp;
                }
            }
        }
    }

    public static void swap(int[] array, int i , int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //堆排序
    public static void heapSort(int[] array) {
//        先建立一个堆
        //这里范围是array.length - 1是因为当堆中的元素只有最后一个的时候，也就一定是有序的
        creatHeap(array);
        for(int i = 0; i < array.length - 1; i++) {
            //交换堆顶元素和堆的最后一个元素
            //堆的元素个数随着循环的进行一直在减少，是array.length - i
            //堆的最后一个元素的下标是array.length - i - 1
            swap(array,0,array.length - 1 - i);
            //交换完之后，要将堆中的最后一个元素删掉，堆的长度也就进一步的变小了
            shiftDown(array,array.length - i - 1,0);
        }
    }

    private static void creatHeap(int[] array) {
        //从最后一个非叶子节点开始往前循环，依次向下调整
        for(int i = (array.length - 1- 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length - 1 - i, 0);
        }
    }
    //向下调整
    public static void shiftDown(int[] array, int heapLength, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapLength) {
            if (child + 1 < heapLength && array[child + 1] > array[child]) {
                child = child + 1;
                //条件结束意味着child就是上面两个当中较大的那个
            }
                if (array[child] > array[parent]) {
                    swap(array, child, parent);
                }else {
                    break;
                }
                parent = child;
                child = 2 * parent + 1;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        //按照每次找最小元素来排序，从后往前比较交换
        for (int bound = 0; bound < array.length; bound++ ) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if(array[cur - 1] > array[cur]) {
                    swap(array, cur - 1, cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        insertSort(array);
        System.out.println("插入排序结果：" +  Arrays.toString(array));

        shellSort(array);
        System.out.println("希尔排序结果：" + Arrays.toString(array));

        selectSort(array);
        System.out.println("选择排序结果：" + Arrays.toString(array));

        heapSort(array);
        System.out.println("堆排序结果：" + Arrays.toString(array));

        bubbleSort(array);
        System.out.println("冒泡排序结果：" + Arrays.toString(array));
    }
}
