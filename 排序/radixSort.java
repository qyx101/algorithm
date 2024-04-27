// https://leetcode.cn/problems/sort-an-array/description/
// 桶排序 - 未完全理解

import java.util.Arrays;

class Solution {

    public static int BASE = 10;

    public static int MAXN = 50001;

    public static int[] help = new int[MAXN];

    public static int[] cnts = new int[BASE];

    public static int[] sortArray(int[] arr) {
        if (arr.length > 1) {
            int n = arr.length;
            // 找出数组中最小的数
            int min = arr[0];
            for (int i = 1;i < n;i++) {
                min = Math.min(min,arr[i]);
            }
            // int a = -6;
            // a = -6 - (-6);
            // 找出数组中最大的数, 并把数组中每个数 -= 最小数, 保证数组中每个数是个正数
            int max = 0;
            for (int i = 0;i < n;i++) {
                arr[i] -= min;
                max = Math.max(max,arr[i]);
            }
            // 根据最大值位数, 决定做几轮
            radixSort(arr,n,bits(max));
            // 最后还原, 每个数 += min
            for (int i = 0; i < n; i++) {
                arr[i] += min;
            }
        }
        return arr;
    }

    private static int bits(int max) {
        // 1234
        int count = 0;
        while (max > 0) {
            count++;
            max /= BASE;
        }
        return count;
    }

    public static void radixSort(int[] arr,int n,int bits) {
        for (int offset = 1;bits > 0;bits--,offset *= BASE) {
            Arrays.fill(cnts, 0);
            for (int i = 0;i < n;i++) {
                cnts[(arr[i] / offset) % BASE]++;
            }
            for (int i = 1;i < BASE;i++) {
                cnts[i] += cnts[i-1];
            }
            for (int i = n-1;i >= 0;i--) {
                help[--cnts[(arr[i] / offset) % BASE]] = arr[i];
            }
            for (int i = 0;i < n;i++) {
                arr[i] = help[i];
            }
        }
    }

    public static void main(String[] args) {
        //int[] arr1 = {2,1,3,0,3};
        //int[] arr2 = {5,2,3,1};
        //sortArray(arr2);
    }

}