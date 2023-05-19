package com.github.base.sort;

import java.util.Arrays;

/**
 * @author hewenji
 * @Date 2023/5/13 11:02
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {4, 6, 5, 2, 1, 7, 8, 9, 3};

        // 插入排序
        /*for (int i=1; i<nums.length; i++) {
            int current = nums[i];
            int preIndex = i-1;
            while (preIndex>=0 && current < nums[preIndex]) {
                nums[preIndex+1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1] = current;
        }*/

        int gap = nums.length / 2;
        while (gap >0 ) {

            for (int i = gap; i<nums.length; i++) {
                int current = nums[i];
                int preIndex = i-gap;
                while (preIndex >=0 && current < nums[preIndex]) {
                    nums[preIndex+gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex+gap] = current;
            }

            gap /=2;
        }


        System.out.println(Arrays.toString(nums));
    }
}
