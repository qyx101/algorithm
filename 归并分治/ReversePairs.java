class Solution {

    public static int MAX_N = 50001;

    public static int[] help = new int[MAX_N];

    public static int reversePairs(int[] arr) {
        return func(arr,0,arr.length-1);
    }

    public static int func(int[]arr,int l,int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        // 总翻转对数量 = 左部分翻转对 + 右部分翻转对 + 跨左右翻转对数量
        return func(arr,l,m) + func(arr,m+1,r) + merge(arr,l,m,r);
    }

    private static int merge(int[] arr,int l,int m,int r) {
        // 计算左跨右翻转对数量
        int ans = 0;
        for (int i = l,j = m+1,sum = 0;i <= m;i++) {
            while (j <= r && arr[i] > (long) 2 * arr[j]) {
                j++;
                sum++;
            }
            ans += sum;
        }
        // 正常merge
        int i = l;
        int a = l,b = m+1;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] =  arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l;i <= r;i++) {
            arr[i] = help[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};

        System.out.println(reversePairs(arr));
    }
}