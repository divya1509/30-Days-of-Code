// Revise again
// Ques - Merge Without Extra Space
// Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. 
// Merge them in sorted order without using any extra space. 
// Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

// Example 1:
// Input: 
// n = 4, arr1[] = [1 3 5 7] 
// m = 5, arr2[] = [0 2 6 8 9]
// Output: 
// arr1[] = [0 1 2 3]
// arr2[] = [5 6 7 8 9]

import java.util.*;
class q3{
    

    private static void display(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};
    }
}