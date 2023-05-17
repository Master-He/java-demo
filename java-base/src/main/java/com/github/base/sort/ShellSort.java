package com.github.base.sort;

import java.util.Arrays;

/**
 * @author hewenji
 * @Date 2023/5/13 11:02
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {4, 6, 5, 2, 1, 7, 8, 9, 3};
        for (int i=0; i<nums.length-1; i++) {
            int current = nums[i+1];
            int preIndex = i;
            while (preIndex >=0 && current < nums[preIndex]) {
                nums[preIndex+1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1] = current;
        }
        System.out.println(Arrays.toString(nums));
    }
}
