知识点: 异或运算

https://leetcode.cn/problems/single-number/

class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int i = 0;i < nums.length;i++) {
            ret ^= nums[i];
        }
        return ret;
    }
}