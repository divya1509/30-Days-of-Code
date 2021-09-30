// Unique Paths
// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
// How many possible unique paths are there?

import java.util.*;
class q5{
    // robot right  dow jaa skta hai to end se start kro r dp mein store kr lo uss cell se end tak kitne path hai
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >=0; j--) {
                if(i == m - 1 || j == n - 1) dp[i][j] = 1;
                else dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
    
    public static void main(String[] args) {
        System.out.println(uniquePaths(5, 7));
    }
}