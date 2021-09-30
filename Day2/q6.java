// Rotate Image
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

import java.util.*;
class q6{
    private static void swap(int[][] arr, int r1, int c1, int r2, int c2) {
        int temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }
    
    private static void transpose(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 0; j < i; j++) {
                swap(matrix, i , j, j, i);
            }
        }
    }
    
    // reverse around cols
    private static void reverse(int[][] matrix) {
        int l = 0 , r = matrix.length - 1;
        while(l < r) {
            for(int i = 0; i < matrix.length; i++) {
                //i -> row
                swap(matrix, i, l, i, r);
            }
            l++;
            r--;
        }
    }
    
    public static void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    public static void main(String[] args) {
        int[][]  arr = {{1,5,8},{4,7,6},{5,3,1}};
        System.out.println(nextPermutation(arr));
    }
}