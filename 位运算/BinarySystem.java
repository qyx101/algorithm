class BinarySystem {
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            // 下面这句写法，可以改成 :
            // System.out.print((a & (1 << i)) != 0 ? "1" : "0");
            // 但不可以改成 :
            // System.out.print((a & (1 << i)) == 1 ? "1" : "0");
            // 因为a如果第i位有1，那么(a & (1 << i))是2的i次方，而不一定是1
            // 比如，a = 0010011
            // a的第0位是1，第1位是1，第4位是1
            // (a & (1<<4)) == 16（不是1），说明a的第4位是1状态
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 非负数
        int a = 78;
        System.out.println(a);
        printBinary(a);
        System.out.println("===a===");

        // 负数
        int b = -6;
        System.out.println(b);
        printBinary(b);
        System.out.println("===b===");

        // 直接写二进制的形式定义变量
        int c = 0b1001110;
        System.out.println(c);
        printBinary(c);
        System.out.println("===c===");

        // 直接写十六进制的形式定义变量
        // 0100 -> 4
        // 1110 -> e
        // 0x4e -> 01001110
        int d = 0x4e;
        System.out.println(d);
        printBinary(d);
        System.out.println("===d===");

        // ~、相反数
        System.out.println(a);
        printBinary(a);
        printBinary(~a);
        int e = ~a + 1;
        System.out.println(e);
        printBinary(e);
        System.out.println("===e===");

        // int、long的最小值，取相反数、绝对值，都是自己
        int f = Integer.MIN_VALUE;
        System.out.println(f);
        printBinary(f);

        System.out.println(-f);
        printBinary(-f);
        System.out.println(~f + 1);
        printBinary(~f + 1);
        System.out.println("===f===");

        // | & ^
        int g = 0b0001010;
        int h = 0b0001100;
        printBinary(g | h);
        printBinary(g & h);
        // 相同为0,相异为1
        printBinary(g ^ h);
        System.out.println("===g、h===");

        // <<
        // 左移, 右边补0
        int i = 0b0011010;
        printBinary(i);
        printBinary(i << 1);
        printBinary(i << 2);
        printBinary(i << 3);
        System.out.println("===i << ===");

        // 非负数 >> >>>，效果一样
        // 右移, 左边补0
        printBinary(i);
        printBinary(i >> 2);
        printBinary(i >>> 2);
        System.out.println("===i >> >>>===");

        // 负数 >> >>>，效果不一样
        // >> 有符号右移
        // >>> 无符号右移
        int j = 0b11110000000000000000000000000000;
        printBinary(j);
        printBinary(j >> 2);
        printBinary(j >>> 2);
        System.out.println("===j >> >>>===");

        // 非负数 << 1，等同于乘以2
        // 非负数 << 2，等同于乘以4
        // 非负数 << 3，等同于乘以8
        // 非负数 << i，等同于乘以2的i次方
        // ...
        // 非负数 >> 1，等同于除以2
        // 非负数 >> 2，等同于除以4
        // 非负数 >> 3，等同于除以8
        // 非负数 >> i，等同于除以2的i次方
        // 只有非负数符合这个特征，负数不要用
        int k = 10;
        System.out.println(k);
        System.out.println(k << 1);
        System.out.println(k << 2);
        System.out.println(k << 3);
        System.out.println(k >> 1);
        System.out.println(k >> 2);
        System.out.println(k >> 3);
        System.out.println("===k===");

    }

}