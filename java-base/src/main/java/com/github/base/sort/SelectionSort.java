package com.github.base.sort;

import java.util.Arrays;

/**
 * @author hewenji
 * @Date 2023/5/13 9:58
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {4, 6, 5, 2, 1, 7, 8, 9, 3};
        for (int i=0; i<nums.length; i++) {
            // 一开始默认nums[i] 是最小的，如果比nums[i]小则换位置, 不要每次都换，先记录最小值的下表，记录完后再换
            int minIndex = i;
            for (int j=i; j<nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;  // 记录最小元素的下标，遍历完全部后才进行交换
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;

        }
        System.out.println(Arrays.toString(nums));
    }
}
