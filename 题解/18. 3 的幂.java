class Solution {
    public boolean isPowerOfThree(int n) {
        // 1162261467 这个数是int范围内 最大的3次幂
        // 3次幂 -> 3,9,27
        return n > 0 && 1162261467 % n == 0; 
    }
}