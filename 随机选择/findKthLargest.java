class Solution {
    public static int findKthLargest(int[] arr, int k) {
        // 1 2 3 4 5
        // 假设 k=2, 找第二大的数 -> 下标: 3
        // 假设 k=1, 找第一大的数 -> 下标: 4
        return randomizedSelect(arr,arr.length - k);
    }

    private static int randomizedSelect(int[] arr,int i) {
        int ans = 0;
        for (int l = 0,r = arr.length-1;l <= r;) {

            // > x || = x || > x
            int x = arr[l + (int) (Math.random() * (r - l + 1))];
            partition(arr,l,r,x);

            if (i < first) {
                r = first-1;
            }else if (i > last){
                l = last + 1;
            }else {
                ans = arr[i];
                return ans;
            }
        }
        return -1;
    }

    public static int first,last;

    private static void partition(int[] arr,int l,int r,int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] < x) {
                swap(arr,first++,i++);
            }else if(arr[i] > x) {
                swap(arr,i,last--);
            }else {
                i++;
            }
        }
    }

    private static void swap(int[]arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        findKthLargest(arr,2);
    }
}