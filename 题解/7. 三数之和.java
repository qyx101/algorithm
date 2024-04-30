https://leetcode.cn/problems/3sum/

class Solution {
    public static List<List<Integer>> threeSum(int[] arr) {
        
        // [-4,-4,-1,0,0,0,1,1,4,4,5,6]
        // 1. 排序 - O(N * logN)
        Arrays.sort(arr);

        // 2. 双指针思路解决问题 - O(N^2)
        List<List<Integer>> ret = new ArrayList<>();
        int n = arr.length;
        for(int i = 0;i < n;) {
            // 如果arr[i]大于0,就可以结束了
            // 因为l -> r 数, 一定都是>= arr[i], 它们相加一定不可能是0
            if (arr[i] > 0) break;
            int left = i+1,right = n-1,target = -arr[i];
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum < target) {
                    left++;
                }
                else if(sum > target) {
                    right--;
                } 
                else {
                    ret.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++; right--;
                    // 调整l,r 
                    // 注意边界: 细节看 -> [0,0,0]
                    while(left < right && arr[left] == arr[left-1]) {
                        left++;
                    }
                    while(right > left && arr[right] == arr[right+1]) {
                        right--;
                    }
                }
            }
            i++;
            // 调整i
            // 注意边界: 细节看 -> [0,0,0]
            while(i < n && arr[i] == arr[i-1]) i++;
        }
        return ret;

    }
}