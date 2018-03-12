package com.jxs;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/3/12.
 */
public class Sum {

    @Test
    public int[] toSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
