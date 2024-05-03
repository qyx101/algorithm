https://leetcode.cn/problems/max-consecutive-ones-iii/

// 解法1: 暴力枚举 + 计数器
// 超时了, 不能通过
 class Solution {
    public static int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int len = 0;
        for (int i = 0;i < n;i++) {
            int j = i,count = 0;
            while (j < n) {
                if (arr[j] == 1) {
                    len = Math.max(len,j-i+1);
                    j++;
                } else if (arr[j] == 0 && count < k) {
                    len = Math.max(len,j-i+1);
                    j++;count++;
                }else {
                    break;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        longestOnes(arr,2);
    }
}

// 最优解: 滑动窗口 + 计数器
class Solution {
    public int longestOnes(int[] arr, int k) {
        //  [1,1,1,0,0,0,1,1,1,1,0,1], K = 2
        int len = 0;
        for(int l = 0,r = 0,zero = 0;r < arr.length;r++) {
            if (arr[r] == 0) zero++;
            while (zero > k) {
                if (arr[l++] == 0) zero--;
            }
            len = Math.max(len,r-l+1);
        }
        return len;
    }
}