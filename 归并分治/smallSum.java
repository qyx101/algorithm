https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469

import java.io.*;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static int MAX_N = 100001;

    public static int[] arr = new int[MAX_N];
    public static int[] help = new int[MAX_N];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0;i < n;i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            out.println(smallSum(0,n-1));
        }
        out.flush();
        out.close();
    }

    public static long smallSum(int l,int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return smallSum(l,m) + smallSum(m+1,r) + merge(l,m,r);
    }

    public static long merge(int l,int m,int r) {
        long ans = 0;
        for (int i = l,j = m+1,sum = 0;j <= r;j++) {
            while (i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
        }

        int a = l,b = m+1,i = l;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l;i <= r;i++) {
            arr[i] = help[i];
        }
        return ans;
    }
}
