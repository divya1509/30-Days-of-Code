// Search a 2D Matrix
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.

import java.util.*;
class q1{
    // binary search for element
    private static boolean bSearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(arr[mid] == target) return true;
            else if(arr[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
    
    // search konsi row mein jana better hai
    public static boolean searchMatrix(int[][] matrix, int target) {
        int idx = 0, n = matrix.length, m = matrix[0].length;
        while(idx < matrix.length) {
            if(matrix[idx][0] <= target && matrix[idx][m - 1] >= target) break;
            idx++;
        }
        
        if(idx == n) return false;
        return bSearch(matrix[idx], target );
    }
    
    public static void main(String[] args) {
        int[]  arr = {{1,5,8},{4,7,6},{5,3,1}};
        System.out.println(maxProfit(arr));
    }
}