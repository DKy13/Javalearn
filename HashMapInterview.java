package hashMap;

import java.util.HashMap;

public class HashMapInterview {

//    判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可:
//    1.数字 1-9 在每一行只能出现一次。
//    2.数字 1-9 在每一列只能出现一次。
//    3.数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    public boolean isValidSudoku(char[][] board) {
        // 输入数据
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // 进行验证
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // 保证当前单元格的值
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // 检查这个值是否已经存在
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }
}