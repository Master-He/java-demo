package com.github.base.sort;

import java.util.Arrays;

/**
 * @author hewenji
 * @Date 2023/5/17 20:00
 */
public class MergeSort {

    public static void mergeSort(int[] nums, int left, int right) {
        // 左闭右闭区间
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);

        // 后序遍历
        // merge(nums, left, mid, right);
        int[] tmp = new int [nums.length];
        for (int k=left; k<=right; k++) {
            tmp[k] = nums[k];
        }
        int i=left;
        int j=mid+1;
        for (int k=left; k<=right; k++) {
            if (i==mid+1) {
                // 左半部分已经没数据
                nums[k] = tmp[j];
                j++;
            } else if (j==right+1) {
                // 右半部分已经没数据了
                nums[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {
                //  特别注意，这里的条件判断用tmp,而不是用nums!!!, 而且是用 <＝
                nums[k] = tmp[i];
                i++;
            } else {
                // 此时tmp[i] > tmp[j]
                nums[k] = tmp[j];
                j++;
            }
        }
    }

//    public static void merge(int[] nums, int left, int mid, int right) {
//        int[] tmp = new int [nums.length];
//        for (int k=left; k<=right; k++) {
//            tmp[k] = nums[k];
//        }
//        int i=left;
//        int j=mid+1;
//        for (int k=left; k<=right; k++) {
//            if (i==mid+1) {
//                // 左半部分已经没数据
//                nums[k] = tmp[j];
//                j++;
//            } else if (j==right+1) {
//                // 右半部分已经没数据了
//                nums[k] = tmp[i];
//                i++;
//            } else if (tmp[i] <= tmp[j]) {
//                //  特别注意，这里的条件判断用tmp,而不是用nums!!!, 而且是用 <＝
//                nums[k] = tmp[i];
//                i++;
//            } else {
//                // 此时tmp[i] > tmp[j]
//                nums[k] = tmp[j];
//                j++;
//            }
//        }
//    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,4,6,1,2,5};

        System.out.print("before sort:");
        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length-1);

        System.out.print("after  sort:");
        System.out.println(Arrays.toString(arr));
    }


}
