package learn;

//有一堆石头，每块石头的重量都是正整数。
//        每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。
//        假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//        如果 x == y，那么两块石头都会被完全粉碎；
//        如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
//        最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        if (len==1) {
            return stones[0];
        }else if (len==2) {
            return Math.abs(stones[0]-stones[1]);
        }else {
            for (int i = len/2-1; i >= 0 ; i--) {
                maxHeap(stones, i, len-1);
            }
            int temp;
            while ((temp=Math.max(stones[1], stones[2]))!=0) {
                stones[0]-=temp;
                if (stones[1]>stones[2]) {
                    stones[1]=0;
                }else {
                    stones[2]=0;
                }
                for (int i = 2; i >= 0 ; i--) {
                    maxHeap(stones, i, len-1);
                }
            }
            return stones[0];
        }
    }
    public void maxHeap(int[] nums, int root, int end) {
        int l=2*root+1;
        int temp=nums[root];
        while (l<=end && (nums[l]>temp || (l+1<=end && nums[l+1]>temp))) {
            if (l+1<=end && nums[l+1]>nums[l]) {
                l++;
            }
            nums[root]=nums[l];
            nums[l]=temp;
            root=l; l=2*root+1;
            temp=nums[root];
        }
    }

}
