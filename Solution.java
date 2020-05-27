package learn;

import java.util.HashSet;
import java.util.Set;

public class Solution {
//    实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//    解法:利用Set去重

    public boolean isUnique(String astr) {
        Set set = new HashSet();
        for (int i = 0; i <astr.length() ; i++) {
            set.add(astr.charAt(i));//charAt方法：
//            java.lang.String.charAt()方法返回指定索引处的char值。
//            索引范围是从0到length() - 1。
        }
        return set.size() == astr.length();
    }
}
