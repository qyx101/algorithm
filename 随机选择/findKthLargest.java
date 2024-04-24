// 无序数组中找第K大的数
// https://leetcode.cn/problems/kth-largest-element-in-an-array/description/

class Solution {

    // 思路转换:
    // 无序数组中找第K大的数 ---> 从小到大排序, arr[数组长度 - k] = 第K大的数

    // 1 2 3 4 5
    // 假设 k=2, 找第二大的数 -> 下标: 3
    // 假设 k=1, 找第一大的数 -> 下标: 4

    public int findKthLargest(int[] arr, int k) {
        return randomizedSelect(arr,arr.length-k);
    }

    // first、last指针一定指向 == x 的区域
    // first - 1 < x 
    // last + 1 > x
    public static int randomizedSelect(int[] arr,int index) {
        for (int l = 0,r = arr.length-1;l <= r;) {
            int x = arr[l + (int)(Math.random() * (r - l + 1))];
            partition(arr,x,l,r);
            if (index > last) {
                l = last + 1;
            } else if (index < first) {
                r = first -1;
            }else {
                return arr[index];
            }
        }
        return -1;
    }
    private static int first,last;

    private static void partition(int[] arr,int x,int l,int r) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] > x) {
                swap(arr,i,last--);
            }else if (arr[i] < x) {
                swap(arr,i++,first++);
            }else {
                i++;
            }
        }
    }

    private static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}