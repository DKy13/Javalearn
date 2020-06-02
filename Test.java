public class Test {
    public static int findKthLargest(int[] nums, int n, int k) {
        n = nums.length;
        if (nums == null || n < k) {
            return 0;
        }
        return find(nums, 0, n - 1, k);
    }

    //逆排序
    private static int find(int[] nums, int left, int right, int k) {
        int key = nums[left];

        while (left < right) {
            while (left < right && nums[right] <= key) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= key) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = key;
        
        if (left == k - 1) {
            return key;
        }
        //比key大的个数少于k-1个，去后半部分找
        if (left < k - 1) {
            return find(nums, left + 1, right, k );
        }
        return find(nums, left, left - 1, k);
    }

    public static void main(String[] args) {
        int[] arr ={6,5,3,2,2,1};
        System.out.println(findKthLargest(arr,6,4));
    }
}
