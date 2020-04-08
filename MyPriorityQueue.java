package Heap0408;

//优先级队列   （以大堆为例）
public class MyPriorityQueue {
    //这里的array看起来是一个数组，其实应该是一个堆的结构
    private int[] array = new int[100];
    private int size = 0;
//进行入队列
    public void offer(int x) {
        //将新插入的元素直接放在数组的尾部
        array[size] = x;
        size++;
        //因为新插入的元素直接放在数组的尾部，这会破坏数组的大堆序列
        //故而要进行向上调整
        shiftUp(array,size - 1);
    }

    public static void shiftUp(int[] array,int index) {
        int child = index;
        int parent = (child - 1)/2;
        //当child = 0 的时候就已经遍历到根节点了
        //因此并不需要知道这个堆有多大，只需要和0比较即可
        while(child > 0) {
            if(array[parent] < array[child]) {
                //这里不满足大堆的结构，需要进行交换
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            }else {
                //满足大堆结构，结束循环
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    //进行出队列操作
    public int poll() {
         //下标为0的元素就是对首元素，也就是要删掉的元素，删掉的同时，也得保证剩下的结构也是一个堆的结构
        int oldValue = array[0];
        array[0] = array[size - 1];//可以将直接将最后一个元素赋值给队首元素就将队首元素删除了
        size--;//将最后一个元素也删除掉
        //此时进行向下调整，将整个堆都调整为大堆
        shiftDown(array, size,0);
        return oldValue;
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        // 这个条件的含义是看看 parent 有没有子节点
        while (child < size) {
            // 把左右子树中较大的节点找到
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // 上述条件结束后, child 肯定对应左右子树中比较大的元素.
            // 再拿当前的这个 child 和 parent 位置的元素比较一下
            if (array[child] > array[parent]) {
                // 交换父子节点的位置
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                // 当前这个位置开始, 已经符合堆的要求了, 不需要继续调整
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    //将队首元素取出来
    public int peek() {
        return array[0];
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println(cur);
        }
    }
}
