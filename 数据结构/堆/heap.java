public class Heap {

    // 堆底层就是数组
    private int[] array;
    private int usedSize;

    public Heap(int[] arr) {
        this.array = arr;
        usedSize = array.length;
    }

    // 4. 堆排序
    // 从小到大排序到建大根堆
    public static void heapSort(int[] arr) {
        // 向下调整建大根堆
        // O(N)
        int size = arr.length;
        for (int i = (size - 1) / 2;i >= 0;i--) {
            siftDown(arr,i,size);
        }
        // O(N * logN)
        while (size > 1) {
            swap(arr,0,--size);
            siftDown(arr,0,size);
        }
    }

    // 3. 删除堆顶数据
    public int poll() {
        // 堆顶数据和最后一个数据交换, size--, 然后下标0位置向下调整
        int ret = array[0];
        swap(array,0,--usedSize);
        siftDown(array,0,usedSize);
        return ret;
    }

    // 2. 往堆里入数据
    public void add(int val) {
        array[usedSize++] = val;
        siftUp(array,usedSize-1);
    }


    // 1. 把数组变成堆
    // 向下调整方式, 从最后一颗子树开始向下调整
    // O(N)
    public static void buildBigHeap1(int[] array,int size) {
        for (int i = (size - 1) / 2;i >= 0;i--) {
            siftDown(array,i,size);
        }
    }

    // 向上调整方式, 从第2个数开始,每进一个数,就向上调整
    // O(N * logN)
    public void buildBigHeap2() {
        for (int i = 1;i < array.length;i++) {
            siftUp(array,i);
        }
    }

    // 向下调整
    // 单次操作复杂度为 O(logN), 大概执行次数等于树的高度
    public static void siftDown(int [] array,int parent,int size) {
        int child = parent * 2 + 1;
        // 进入循环, 就是有左孩子
        while (child < size) {
            // 找出左右孩子,最大的那个
            if (child + 1 < size && array[child + 1] > array[child]) {
                child++;
            }
            // child > parent, 交换
            if (array[child] > array[parent]) {
                swap(array,child,parent);
                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }
    // 向上调整
    // 单次操作复杂度为 O(logN), 大概执行次数等于树的高度
    public static void siftUp(int [] array,int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (array[child] > array[parent]) {
                swap(array,child,parent);
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        Heap heap = new Heap(arr);
        // 测试 向下调整方式建堆
        //heap.buildBigHeap1();

        // 测试 向上调整方式建堆
        heap.buildBigHeap2();

        // 测试 插入、删除堆顶数据
        System.out.println(heap.poll());
        heap.add(70);
    }
}
