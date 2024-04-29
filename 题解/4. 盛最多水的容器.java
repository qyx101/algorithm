知识点: 双指针
https://leetcode.cn/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int i = 0,j = height.length-1,max = 0;
        while (i < j) {
            int minHeight = Math.min(height[i],height[j]);
            max = Math.max(max,minHeight * (j-i));
            if (height[i] <= height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return max;
    }
}