import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息

// 找最多线段重合
// 知识点: 堆, 比较器
// https://www.nowcoder.com/practice/1ae8d0b6bb4e4bcdbf64ec491f63fc37

public class Main {

    // 输入, 输出
    public static int MAX_N = 10001;

    public static int[][] line = new int[MAX_N][2];

    public static int n = 0;

    // 自己撸个小根堆
    private static int[] array = new int[MAX_N];
    private static int usedSize;

    // 删除堆顶数据
    public static int poll() {
        // 堆顶数据和最后一个数据交换, size--, 然后下标0位置向下调整
        int ret = array[0];
        swap(array,0,--usedSize);
        siftDown(array,0,usedSize);
        return ret;
    }

    // 往堆里入数据
    public static void add(int val) {
        array[usedSize++] = val;
        siftUp(array,usedSize-1);
    }

    // 向下调整
    // 单次操作复杂度为 O(logN), 大概执行次数等于树的高度
    public static void siftDown(int [] array,int parent,int size) {
        int child = parent * 2 + 1;
        // 进入循环, 就是有左孩子
        while (child < size) {
            // 找出左右孩子,最小的那个
            if (child + 1 < size && array[child + 1] < array[child]) {
                child++;
            }
            // child < parent, 交换
            if (array[child] < array[parent]) {
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
            if (array[child] < array[parent]) {
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


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0;i < n;i++) {
                in.nextToken();
                line[i][0] = (int) in.nval;
                in.nextToken();
                line[i][1] = (int) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        out.close();
    }

    // { [1,5], [1,2], [2,4], [5,9], [2,6]}
    // 总: O(N * logN)
    public static int compute() {
        usedSize = 0;
        // 排序:
        // { [1,5], [1,2], [2,4], [2,6], [5,9] }
        // 谁第一个数小,谁优先级高

        // O(N * logN)
        Arrays.sort(line,0,n,(o1,o2) -> o1[0] - o2[0]);

        // O(N * logN)
        // 每个数据就是进一次堆,出一次堆
        int ans = 0;
        for (int i = 0;i < n;i++) {
            while (usedSize > 0 && line[i][0] >= array[0]) {
                poll();
            }
            add(line[i][1]);
            // 统计最多线段数
            ans = Math.max(ans,usedSize);
        }
        return ans;
    }


    // leetcode 题解
    // https://leetcode.cn/problems/meeting-rooms-ii/description/

    class Solution {
        public int minMeetingRooms(int[][] array) {
            Arrays.sort(array,0,array.length,(o1,o2) -> o1[0] - o2[0]);
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            int ans = 0;
            for (int i = 0;i < array.length;i++) {
                while (!heap.isEmpty() && array[i][0] >= heap.peek()) {
                    heap.poll();
                }
                heap.add(array[i][1]);
                ans = Math.max(ans,heap.size());
            }
            return ans;
        }
    }
}