// 知识点: 堆, 比较器

https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/
class Solution {
    public int halveArray(int[] arr) {
        // 建大根堆
        PriorityQueue<Double> heap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        double sum = 0;
        // O(N * logN)
        for (double val:arr) {
            heap.add(val);
            sum += val;
        }
        sum /= 2;

        int ans = 0;
        // O(N * logN)
        for (double minus = 0,cur = 0;minus < sum;ans++,minus += cur) {
            // 当前减少的幅度
            cur = heap.poll() / 2;
            heap.add(cur);
        }
        return ans;
    }

    // 下面是优化写法
    // 解题思路都是一样的

    public static int MAXN = 100001;

    public static long[] heap = new long[MAXN];

    public static int size;

    // 提交时把halveArray2改名为halveArray
    public static int halveArray2(int[] nums) {
        size = nums.length;
        long sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            heap[i] = (long) nums[i] << 20;
            sum += heap[i];
            heapify(i);
        }
        sum /= 2;
        int ans = 0;
        for (long minus = 0; minus < sum; ans++) {
            heap[0] /= 2;
            minus += heap[0];
            heapify(0);
        }
        return ans;
    }

    public static void heapify(int i) {
        int l = i * 2 + 1;
        while (l < size) {
            int best = l + 1 < size && heap[l + 1] > heap[l] ? l + 1 : l;
            best = heap[best] > heap[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(best, i);
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void swap(int i, int j) {
        long tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}