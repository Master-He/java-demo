package com.github.base.sort;

import java.util.Arrays;

/**
 * @author hewenji
 * @Date 2023/5/13 9:49
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {4, 6, 5, 2, 1, 7, 8, 9, 3};

        for (int i=0; i<nums.length-1; i++) {
            for (int j=0; j<nums.length-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
