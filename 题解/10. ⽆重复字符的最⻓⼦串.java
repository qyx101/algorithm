https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/

// 解法1: 暴力枚举 + 哈希表
// O(N^2) 不好
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), len = Integer.MIN_VALUE;
        for (int i = 0;i < n;i++) {
            int[] arr = new int[128];
            for (int j = i;j < n;j++) {
                char ch = s.charAt(j);
                // 用哈希表记录字符个数
                if (arr[ch] == 1) break;
                arr[ch]++;
                len = Math.max(len,j-i+1);
            }
        }
        return len == Integer.MIN_VALUE ? 0 : len;
    }
}

// 最优解: 移动窗口思路 + 哈希表
// O(N)
class Solution {
    public int lengthOfLongestSubstring(String str) {
        // "abcdcbaeb"
        char[] arr = str.toCharArray();
        int[] count = new int[128];
        int l = 0,r = 0,len = 0,n = arr.length;
        while (r < n) {
            count[arr[r]]++;
            while (count[arr[r]] > 1) {
                count[arr[l]]--;
                l++;
            }
            len = Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
}