package learn;

//数组中值出现了一次的数字-----牛客网
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Learn0621 {
    public static void func(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer c : arr) {
            int k = map.getOrDefault(c, 0);
            map.put(c, k + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 == 1) {
                System.out.println(e.getKey() + " ");
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        func(arr);
    }
}
