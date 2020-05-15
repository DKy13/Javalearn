package learn0510;
//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
public class SubarySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
