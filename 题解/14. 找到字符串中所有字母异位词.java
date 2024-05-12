https://leetcode.cn/problems/find-all-anagrams-in-a-string/

// 知识点: 滑动窗口 + 哈希表 (数组模拟)


// 1. 击败: 60 %
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ret = new ArrayList<>();
        char[] sample = new char[26];
        char[] hash = new char[26];

        int n = p.length();
        for (int i = 0;i < n;i++) {
            char ch = p.charAt(i);
            sample[ch-97]++;
        }

        for (int l = 0,r = 0;r < s.length();r++) {
            char in = s.charAt(r);
            hash[in-97]++;
            if (r-l+1 > n) {
                char out = s.charAt(l);
                hash[out-97]--;
                l++;
            }
            if (check(sample,hash)) {
                ret.add(l);
            }
        }
        return ret;
    }

    private boolean check(char[] sample,char[] hash) {
        for (int i = 0;i < sample.length;i++) {
            if (sample[i] != hash[i]) {
                return false;
            }
        }
        return true;
    }
}

// 2. 优化
// 击败: 70 %
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ret = new ArrayList<>();
        char[] sample = new char[26];
        char[] hash = new char[26];

        // 1. 统计p字符串中, 每个字符出现的次数
        int n = p.length();
        for (int i = 0;i < n;i++) {
            char ch = p.charAt(i);
            sample[ch-97]++;
        }

        // 2. 滑动窗口解题
        for (int l = 0,r = 0,count = 0;r < s.length();r++) {
            char in = s.charAt(r);
            hash[in-97]++;
            if (hash[in-97] <= sample[in-97]) count++;
            if (r-l+1 > n) {
                char out = s.charAt(l);
                hash[out-97]--;
                if (hash[out-97] < sample[out-97]) count--;
                l++;
            }
            if (count == n)  ret.add(l);        
        }
        return ret;
    }

}