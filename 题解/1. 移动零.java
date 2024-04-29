知识点: 双指针

https://leetcode.cn/problems/move-zeroes/

class Solution {
    public void moveZeroes(int[] arr) {
        for (int cur = 0,dst = -1;cur < arr.length;cur++) {
            if (arr[cur] != 0) {
                dst++;
                int tmp = arr[cur];
                arr[cur] = arr[dst];
                arr[dst] = tmp;
            }
        }
    }
}