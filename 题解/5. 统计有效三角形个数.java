知识点: 双指针

https://leetcode.cn/problems/valid-triangle-number/

class Solution {
    public int triangleNumber(int[] arr) {
        // [2,2,3,4,8,9,10]
        // O (N * logN) 
        Arrays.sort(arr);
        int n = arr.length,count = 0;

        // O(n^2)
        for (int i = n-1;i >= 2;i--) // 固定最大那条边
        {
            // 统计所有, 固定最大边组合个数
            int l = 0,r = i-1;
            while (l < r) {
                if (arr[l] + arr[r] > arr[i]) {
                    count += (r - l);
                    r--;
                }else {
                    l++;
                }
            }
        }
        return count;
    }
}