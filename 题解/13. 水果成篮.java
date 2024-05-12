https://leetcode.cn/problems/fruit-into-baskets/

知识点: 滑动窗口 + 哈希表

// 1. 滑动窗口 + （容器）哈希表
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = Integer.MIN_VALUE, n = fruits.length;
        for (int l = 0,r = 0;r < n;r++) {
            int in = fruits[r];
            map.put(in,map.getOrDefault(in,0) + 1);
            while (map.size() > 2) {
                int out = fruits[l];
                map.put(out,map.get(out)-1);
                if (map.get(out) == 0) 
                    map.remove(out);
                l++;
            }
            len = Math.max(len,r-l+1);
        }
        return len;
    }
}

// 2. 滑动窗口 + 哈希表 (数组模拟)

class Solution {
    
    public  int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] hash = new int[n];

        int len = Integer.MIN_VALUE;
        for (int l = 0,r = 0,kinds = 0;r < n;r++) {
            int in = fruits[r];
            if (hash[in] == 0) kinds++;
            hash[in]++;
            while (kinds > 2) {
                int out = fruits[l];
                hash[out]--;
                if (hash[out] == 0) kinds--;
                l++;
            }
            len = Math.max(len,r-l+1);
        }
        return len;
    }


}