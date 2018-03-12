package com.jxs.easy;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/3/12.
 */
public class ReverseInteger {

    public int reverse(int x) {

        //判断x是否在int型范围内
        if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) {
            return 0;
        }
        int num = 9;
        for (int n = 1; n <= num; n++) {
            if (x > 0 && x <10) {
                return x;
            }
            if (Math.abs(x / Math.pow(10, n)) > 0 && Math.abs(x / Math.pow(10, n)) < 10) {
                // 记录最大位数
                int max = n;
                // 和
                long sum = 0;
                // 10的n次方
                int a = 0;
                // 记录每一位的值
                int b = 0;
                while (n >= 0) {
                    a = (int) Math.pow(10, n);
                    b = x / a;
                    x -= b * a;
                    sum += b * Math.pow(10,max - n);
                    n--;
                }
                if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {
                    return 0;
                } else {
                    return (int) sum;
                }
            }
        }
        return 0;
    }

    @Test
    public void test() {
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(123));
    }
}
