// Set Matrix Zeroes
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

// You must do it in place.

import java.util.*;
class q1{
    private static void solveConstantSpace(int[][] matrix) {
        // same as extra space bas isme matrix ko khud space le kr banay ahai
        // starting of col n row ko indicator banaya hai to show if change is needed or not
        // 0th row col ko separate krna zaroori haicoz ek cell do info ni rkh payega
        // isliey extra variable bnaya hai 0 col k liye
        int n = matrix.length, m = matrix[0].length;
        boolean first = false;
        
        for(int i = 0; i < n; i++) {
            if(matrix[i][0] == 0) first = true;
            
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(matrix[0][0] == 0) {
            for(int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
        if(first) {
            for(int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        
    }
    
    public static void solveExtraSpace(int[][] matrix) {

        // row mein store karwa lo ki konsi row n col ko cahnge krna hai
        int n = matrix.length, m = matrix[0].length;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(rows[i] == true || cols[j] == true) {
                    matrix[i][j]  = 0;
                }
            }
        }
    }
    private static void display(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        solveExtraSpace(arr);
        solveConstantSpace(arr);

    }
}

