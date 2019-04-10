package com.jxs.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            // 剪枝操作，当起始点已经到正数时，已经不可能再有三个数之和为0了
            if (nums[index] > 0) {
                break;
            }
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            int target = -nums[index];
            int i = index + 1;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[index]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    ret.add(list);
                    while (i < j && nums[i + 1] == nums[i]) {
                        i++;
                    }
                    while (i > j && nums[j - 1] == nums[j]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else if (nums[i] + nums[j] > target) {
                    j--;
                }
            }
        }
        return ret;
    }

    @Test
    public void test() {

        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(num));
    }
}
