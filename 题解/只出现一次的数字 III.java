知识点: 异或运算

https://leetcode.cn/problems/single-number-iii/description/

class Solution {
    public int[] singleNumber(int[] arr) {
        int num1 = 0;
        for(int v:arr) {
            num1 ^= v;
        }
        // num1 等于要找的两个数的异或和   
        // num1 = a ^ b

        // 难点: 如何分别找到a,b这两个数 ?
        // 已知a,b肯定是两个不同的数, 二进制位不同,
        // 所以, 异或出来肯定有1位是1
    
        // 3 : 0 0 1 1
        // 5 : 1 0 0 1
        // 3 ^ 5 = 6 (1 0 1 0)

        // 提取最右侧的1

        // 6 & -6 -> 
        //   1 0 1 0     
        // & 
        //   0 1 1 0
        // sign = 0 0 1 0

        int num2 = 0;
        int sign = num1 & (-num1); 
        
        for (int v : arr) {
            if ( (v & sign) == 0) {
                num2 ^= v;
            }
        }
        return new int[]{num2, num1 ^ num2};
    }
}