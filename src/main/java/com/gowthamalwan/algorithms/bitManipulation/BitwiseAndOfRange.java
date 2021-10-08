package com.gowthamalwan.algorithms.bitManipulation;

public class BitwiseAndOfRange {
    public static void main(String[] args) {
        int l = 45, r = 53;
        System.out.println(rangeBitwiseAnd1(l, r));
    }

    public static int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            if ((left & 1 << i) == (right & 1 << i)) {
                ans |= left & 1 << i;
            } else {
                break;
            }
        }
        return ans;
    }

    public static int rangeBitwiseAnd1(int left, int right) {
        if (left == 0) {
            return 0;
        }
        int mask = 1;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            mask <<= 1;
        }
        return left * mask;
    }
}
