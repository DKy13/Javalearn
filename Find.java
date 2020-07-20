package learn;

//在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
// 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
// 判断数组中是否含有该整数。
public class Find {
    public boolean Find(int target, int [][] array) {
        if(array == null) {
            return false;
        }
        int i = 0;
        int j = array[0].length - 1;//第0行的长度,即二维数组的列数
        while(i < array[0].length && j >= 0) {
            if(target < array[i][j]){
                j--;
            }else if(target > array[i][j]){
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
}
