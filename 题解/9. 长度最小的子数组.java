// 知识点: 移动窗口

https://leetcode.cn/problems/minimum-size-subarray-sum/

// 暴力枚举解法, 过不了
// O(n^2)
class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int ret = Integer.MAX_VALUE;

        for(int i = 0;i < n;i++) {
            int sum = 0;
            for (int j = i;j < n;j++) {
                sum += arr[j]; 
                if (sum >= target) {
                    // 必须得返回最短区间
                    ret = Math.min(ret,(j-i+1));
                    break;
                }
            }
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
}

// 移动窗口解法:
// O(N)
class Solution {
    public int minSubArrayLen(int target, int[] arr) {

        // target = 7, nums = [2,3,1,2,4,3]
        int n = arr.length,sum = 0;
        int len = Integer.MAX_VALUE;
        for (int l = 0,r = 0;r < n;r++) {
            sum += arr[r];
            while (sum >= target) {
                len = Math.min(len,r-l+1);
                sum -= arr[l++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}