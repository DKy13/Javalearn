package learn;

public class MinInRotateArray {
    //第一种方法:
   /* public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length ==0) {
            return 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1]) {
                return array[i+1];
            }
        }
        return 0;
    }*/
    //第二种方法:二分查找
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = left + ((right - left) / 2);
            if (array[right] == array[left] && array[left] == array[mid]) {
                int result = array[left];
                for (int i = left + 1; i < right; i++) {
                    if (array[i] < result) {
                        result = array[i];
                    }
                }
                return result;
            }
            if (array[mid] >= array[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[mid];
    }
}

