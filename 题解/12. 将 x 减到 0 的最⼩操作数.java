https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/

class Solution {
    public int minOperations(int[] arr, int x) {
        // 找到最小操作数 = 总数组长度 - 最长子数组长度
        // 找到最长子数组之和 (target) = total - x
        int total = 0;
        for(int v:arr) {
            total += v;
        }
        // 注意: [1,1], x = 3 
        if (total < x) {
            return -1;
        }
        int target = total - x;
        int len = Integer.MIN_VALUE;
        int n = arr.length;
        // 找到最长子数组长度
        for (int l = 0,r = 0,sum = 0;r < n;r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l++];
            }
            if (sum == target) {
                len = Math.max(len,r-l+1);
            }
        }
        // 注意: [5,6,7,8,9], x = 4
        return len == Integer.MIN_VALUE ? -1 : n-len;
    }
}