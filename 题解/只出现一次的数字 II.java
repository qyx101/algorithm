知识点: 异或运算

https://leetcode.cn/problems/single-number-ii/


class Solution {
    public int singleNumber(int[] arr) {
        return func(arr,3);
    }

   
    public int func(int[] arr, int m) {
        // [2, 2, 3, 2]
        // count: [1, 4, 0, 0]
        int[] count = new int[32];
        for(int v: arr) {
            for (int i = 0;i < 32;i++) {
                count[i] += (v >> i) & 1;
            }
        }

        //    0 0 0 0
        // |= 0 0 0 1 ——》 0 0 0 1
        // |= 0 0 1 0 ——》 0 0 1 1
        int ans = 0;
        for (int i = 0;i < 32;i++) {
            if (count[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}