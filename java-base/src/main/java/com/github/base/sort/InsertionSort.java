package com.github.base.sort;

import java.util.Arrays;

/**
 * @author hewenji
 * @Date 2023/5/13 10:16
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {4, 6, 5, 2, 1, 7, 8, 9, 3};

//        for (int i=0; i< nums.length-1; i++) {
//            // i已经i之前的nums[i]都是已经排好序的
//            // 双指针， current，preIndex
//            int current = nums[i+1];
//            int preIndex = i;
//            // [1,3,2,0], 中[1]是排好学的，此时current=3,preIndex=0, 3比1大，所以nums[preIndex+1]=3
//            // [1,3,2,0], 中[1,3]是排好序的，此时current=2, preIndex=1, 2比3小，然后preIndex=1-1=0,2比1大，所以nums[preIndex+1]= nums[1]=2;
//            // [1,2,3,0], 中[1,3]是排好序的, 最后preIndex=-1, nums=[1,1,2,3], nums[preIndex+1] = nums[0] = 0;
//            // 最后数组为[0,1,2,3]
//            while (preIndex >=0 && current < nums[preIndex]) {
//                nums[preIndex+1] = nums[preIndex]; //大于current的数要后移，腾出位子给current
//                preIndex--;
//            }
//            // 此时preIndex+1就是要存放数据的数组下标
//            nums[preIndex+1] = current;
//        }

        // 简化：
//        for (int i=0; i<nums.length-1; i++) {
//            int current = nums[i+1];
//            int preIndex = i;
//            while (preIndex >=0 && current < nums[preIndex]) {
//                nums[preIndex+1] = nums[preIndex];
//                preIndex--;
//            }
//            nums[preIndex+1] = current;
//        }

        // 另外一个版本
        for (int i=1; i<nums.length; i++) {
            int current = nums[i];
            int preIndex = i-1;
            while (preIndex>=0 && current < nums[preIndex]) {
                nums[preIndex+1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1] = current;
        }
        System.out.println(Arrays.toString(nums));
    }
}
