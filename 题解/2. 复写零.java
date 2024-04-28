知识点: 双指针

https://leetcode.cn/problems/duplicate-zeros/

class Solution {
    public void duplicateZeros(int[] arr) {        
        // 1. 找到最后一个复写的数
        //            c
        // [1,0,2,3,0,4,5,0]
        //                d
        int cur = 0,dst = -1,n = arr.length;
        while(cur < n) {
            if (arr[cur] != 0) {
                dst++;
            }else {
                dst += 2;
            }
            if (dst >= n - 1) {
                break;
            }
            cur++;
        }

        // 2. 处理特殊情况
        //               c
        //  [1, 0, 2, 3, 0, 4]
        //                    d 
       //             c
        //  [1, 0, 2, 3, 0, 0]
        //               d 
        if (dst >= n) {
            arr[n - 1] = 0;
            cur -= 1;
            dst -= 2;            
        }

        // 3. 正常从后往前复写
        while (cur >= 0) {
            if (arr[cur] != 0) {
                arr[dst--] = arr[cur--];
            }else {
                arr[dst--] = 0;
                arr[dst--] = 0;
                cur--;
            }
        }
    }
}