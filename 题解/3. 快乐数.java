知识点: 双指针

https://leetcode.cn/problems/happy-number/

class Solution {
    // 返回val这个数,每一位的平方和
    public int bitSum(int val) {
        int sum = 0;
        while (val != 0) {
            int v = val % 10;
            sum += v * v;
            val /= 10;
        }
        return sum;
    }
    // 最终一定都会成环
    // 成环有两种情况: 环里的数都是 1 (是快乐数) / != 1 (不是快乐数)
    // 19 -> 82 -> 68 -> 100 -> 1 ..... 成环了
    // 2 -> 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4 ..... 成环了
    public boolean isHappy(int n) {
        int slow = n, fast = bitSum(n);
        while (fast != slow) {
            slow = bitSum(slow);
            fast = bitSum(bitSum(fast));
        }
        return slow == 1;
    }
}