package com.mt.fpb.common.util;

import java.util.Arrays;

public class PlayUtil {


    public static void main(String[] args) {

        int arr[] = {1, 4, 5, 3, 6};
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                int temp;
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
