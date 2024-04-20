// https://leetcode.cn/problems/sort-an-array/

import java.util.Arrays;

class Solution {
    public static final int MAX_N = 100001;

    public static int[] help = new int[MAX_N];

    public int[] sortArray(int[] arr) {

        //mergeSort1(arr,0,arr.length-1);
        mergeSort2(arr);
        return arr;
    }

    // 递归版
    public static void mergeSort1(int[] arr,int l,int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort1(arr,0,mid);
        mergeSort1(arr,mid + 1,r);
        merge(arr,l,mid,r);
    }
    // 非递归版
    public static void mergeSort2(int[] arr) {
        int n = arr.length;
        // O(logN)
        for (int l,r,m,step = 1;step < n;step *= 2) {
            // O(N)
            // 就是把, help数组 拷贝回原数组
            l = 0;
            while (l < n) {
                // 左部分右边界下标 = l + (step - 1)
                m = l + (step - 1);
                // 没有右边界, 直接break, 不需要merge
                if (m + 1 >= n) {
                    break;
                }
                // 右部分左边界下标 = m + 1;
                // 右部分右边界下标 = Math.min(l + (step * 2) - 1,n - 1)
                r = Math.min(l + (step * 2) - 1,n - 1);
                merge(arr,l,m,r);
                l = r + 1;
            }
        }
    }

    // O(N)
    private static void merge(int[] arr,int l,int mid,int r) {
        int a = l;
        int b = mid + 1;
        int i = l;
        while (a <= mid && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= mid) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l;i <= r;i++) {
            arr[i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,2,3,3,4,6,9,3,1};
        mergeSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}