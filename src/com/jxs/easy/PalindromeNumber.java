package com.jxs.easy;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/3/12.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        int cnt = 0;
        String number = x + "";
        char[] numbers = number.toCharArray();
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[numbers.length - i -1];
            if (numbers[i] == temp) {
                cnt++;
            }
        }
        if (cnt == Math.ceil(numbers.length / 2)) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(-10));
    }
}
