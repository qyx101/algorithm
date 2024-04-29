https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/

class Solution {
    public int[] twoSum(int[] price, int target) {
        int l = 0,r = price.length-1;
        while (l < r) {
            int sum = price[l] + price[r]; 
            if (sum > target) {
                r--;
            }else if (sum < target) {
                l++;
            }else {
                break;
            }
        }
        return new int[]{price[l],price[r]};
    }
}