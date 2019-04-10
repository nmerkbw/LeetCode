package com.jxs.easy;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/3/12.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    private void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.print("]");
    }
    @Test
    public void test() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2,7,11,15};
        printArray(twoSum.twoSum(nums,9));
    }
}
