package set0417;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
//        1.实例化Set
        Set<String> set = new HashSet<>();
//        2.往Set中插入元素  add
        set.add("java");
        set.add("Hello");
        set.add("World");
//        3.判断某个值是否存在
        System.out.println(set.contains("Hello"));
//        4.删除某个值
        set.remove("java");
        System.out.println(set.contains("java"));
//        5.遍历打印set
//       1)第一种方法 System.out.println(set);
//       2)第二种方法：利用Iterator（迭代器）进行循环遍历，迭代器的泛行参数必须和集合类中保存的元素参数类型一致
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
