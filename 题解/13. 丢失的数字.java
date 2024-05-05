知识点: 异或运算

https://leetcode.cn/problems/missing-number/

class Solution {
    public static int missingNumber(int[] nums) {
        // sumA: 0 ^ 1 ^ 2 ^ 3
        // sumB: 3 ^ 0 ^ 1
        int sumA = 0,sumB = 0;
        int n = nums.length;
        for (int i = 0;i < n;i++) {
            sumA ^= i;
            sumB ^= nums[i];
        }
        sumA ^= n;
        return sumA ^ sumB;    
    }
}