package com.github.base.sort;

import java.util.Arrays;

/**
 * @author hewenji
 * @Date 2023/5/17 19:22
 */
public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        // 左闭右闭区间
        // 终止条件， 左下标等于右下标
        if (left >= right) return;

        int i = left;
        int j = right;

        int pivot = arr[i]; // 参考
        while (i < j) {
            while(i < j && arr[j] > pivot) {
                j--; // 从右向左找第一个小于pivot的数
            }

            if(i < j) {
                arr[i++] = arr[j];
            }

            while(i < j && arr[i] < pivot) {
                i++; // 从左向右找第一个大于pivot的数
            }

            if(i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = pivot;


        quickSort(arr, left, i-1); /* 递归调用 */
        quickSort(arr, i+1, right); /* 递归调用 */

    }

    public static void main(String[] args) {

        int[] arr = new int[]{3,4,6,1,2,5};

        System.out.print("before sort:");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length-1);

        System.out.print("after  sort:");
        System.out.println(Arrays.toString(arr));
    }

}
