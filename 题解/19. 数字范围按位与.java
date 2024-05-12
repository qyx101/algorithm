知识点: 位运算

https://leetcode.cn/problems/bitwise-and-of-numbers-range/

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // 13: 1101
        // 14: 1110
        // 15: 1111
        while (left < right) {
            right -= (right & -right);
        }
        return right;
    }
}