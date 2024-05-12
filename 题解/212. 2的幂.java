知识点: 异或运算

https://leetcode.cn/problems/power-of-two/

class Solution {
    public boolean isPowerOfTwo(int n) {
        // (n & -n) ——》 找到一串二进制位最右的1
        // 4 -> (1000 == 1000
        // 3 -> (0011 != 0001)   
        return n > 0 && n == (n & -n);
    }
}