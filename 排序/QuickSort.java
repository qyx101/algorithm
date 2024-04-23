// 随机快速排序
https://leetcode.cn/problems/sort-an-array/

public class QuickSort1 {

    // 经典版
    public static void quickSort1(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        // 1. 等概率搞出 l -> r 区间内的一个数
        int x = arr[l + (int) (Math.random() * (r - l + 1))];
        // 2. 进行 partition
        // <= x | ==x (只选一个) | > x
        int mid = partition1(arr,x,l,r);
        quickSort1(arr,l,mid-1);
        quickSort1(arr,mid+1,r);
    }

    //  <= x | ==x (1个x) | > x
    private static int partition1(int[] arr,int x,int l,int r) {
        int a = l,sign = -1;
        for (int i = l;i <= r;i++) {
            if (arr[i] <= x) {
                swap(arr,a,i);
                if (arr[a] == x) {
                    sign = a;
                }
                a++;
            }
        }
        swap(arr,a-1,sign);
        return a-1;
    }

    // 改进版
    public static int first,last;

    public void quickSort2(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int) (Math.random() * (r - l + 1))];
        partition2(arr,x,l,r);
        int left = first;
        int right = last;
        quickSort2(arr,l,left-1);
        quickSort2(arr,right+1,r);
    }

    // <x || == x (所有x) || > x
    private static void partition2(int[] arr,int x,int l,int r) {
        first = l;
        last = r;
        int i = l;
        // > x, swap(i,last), last--, i不变;
        // == x, i++;
        // < x, swap(i,first), i++,first++
        while (i <= last) {
            if (arr[i] > x) {
                swap(arr,i,last--);
            } else if (arr[i] == x) {
                i++;
            } else {
                swap(arr,i++,first++);
            }
        }
    }


    private static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        //int[] arr = {3,1,5,2,4,7,1,9};
        int[] arr = {7,1,5,4,9,6,4,2,5};
        //quickSort1(arr,0,arr.length-1);

    }
}
