package set0417;

import java.util.HashMap;
import java.util.Map;

//只出现一次的数字   解决办法：
public class MapInterview {
//    第一种方法：使用异或的方式，a异或两次b得到的还是a，所以最后剩下的一定就是只出现一次的那个数字
//    public int singleNumber(int[] nums) {
//        int ret = 0;
//        for (int x:nums) {
//            ret ^= x;
//        }
//        return ret;
//    }


//    第二种方法：
// 创建一个Map统计每个数字出现的次数  Map<Integer,Integer>
//key表示当前的数字，value表示这个数字出现的次数
//然后遍历Map找到那个只出现一次的数字即可
    public int singleNumber (int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        //遍历数组
        for (int x : nums) {
            Integer value = map.get(x);
            if (value == null) {
                //当前这个数字在map中不存在，新增加一个键值对
                map.put(x , 1);
            }else {
                //当前这个数字已经存在了，把value加1即可
                map.put(x , value + 1);
            }
    }
        System.out.println("统计出现次数结果：");
        System.out.println(map);
        //遍历map，找到只出现1次的数字
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            //getValue 得到的是 Integer 包装类，
            //通过 equals 判定相对于对 1 进行自动装箱，比较两个 Integer 的值
            //如果写成entry.getValue() == 1, 相对于对 Integer 进行自动拆箱，比较 ==两边的值是否相等
            if(entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
}

    public static void main(String[] args) {
        MapInterview  interview  = new MapInterview();
        int[] array = {1, 2, 1, 4, 2};
        System.out.println(interview.singleNumber(array));
    }
}
