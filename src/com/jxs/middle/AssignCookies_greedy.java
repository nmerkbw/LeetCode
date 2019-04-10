package com.jxs.middle;

import org.junit.Test;

public class AssignCookies_greedy {

    public int findContentChildren(int[] g, int[] s) {

        int cnt = 0;
        for (int i = 0, j = 0; i < g.length && j <s.length;) {
            if (g[i] <= s[j]) {
                i++;
                cnt++;
            }
            j++;
        }
        return cnt;
    }

    @Test
    public void test() {

        int[] g = {3, 4, 5};
        int[] s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }
}
