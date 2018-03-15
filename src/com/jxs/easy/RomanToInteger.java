package com.jxs.easy;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/3/13.
 */
public class RomanToInteger {

    public int romanToInt(String s) {

        char[] romans = s.toCharArray();
        int num = 0;
        for (int i = 0; i < romans.length; i++) {
            if ((i + 1) < romans.length) {
                if (getRomanReverseToInt(romans[i]) < getRomanReverseToInt(romans[i + 1])) {
                    num -= getRomanReverseToInt(romans[i]);
                } else {
                    num += getRomanReverseToInt(romans[i]);
                }
            }
        }
        num += getRomanReverseToInt(romans[romans.length - 1]);
        return num;
    }

    private int getRomanReverseToInt(char ch) {

        switch (ch) {

            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    @Test
    public void testRomanToInt() {

        String roman = "MMMCMXCIX";
        System.out.println(romanToInt(roman));
    }
}
