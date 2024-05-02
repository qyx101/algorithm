知识点: 双指针

https://leetcode.cn/problems/4sum/

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        // 1. 从小到大排序
        Arrays.sort(arr);
        // 2. 利用双指针解题
        List<List<Integer>> ret = new ArrayList<>();
        int n = arr.length;
        for(int i = 0;i <= n-4;) {
            for(int j = i+1;j <= n-3;) {
                //if (arr[j] > 0) break;
                int l = j+1,r = n-1;
                long total = target - (long)arr[i] - arr[j];
                while (l < r) {
                    int sum = arr[l] + arr[r];
                    if (sum < total) l++;
                    else if(sum > total) r--;
                    else {
                        ret.add(Arrays.asList(arr[i],arr[j],arr[l],arr[r]));
                        l++;r--;
                        // 去重
                        while (l < r && arr[l] == arr[l-1]) l++;
                        while (l < r && arr[r] == arr[r+1]) r--;                       
                    }
                }
                j++;
                // 去重
                while(j < n && arr[j] == arr[j-1]) j++;
            }
            i++;
            // 去重
            while(i < n && arr[i] == arr[i-1]) i++;
        }
        return ret;
    }
}