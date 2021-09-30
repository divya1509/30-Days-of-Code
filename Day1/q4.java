// Ques-
// Kadane’s Algorithm 
// Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum. 

import java.util.*;
class q4{
    private static void Kadane(int[] arr, int n) {
        int os = 0, oe = 0, curr = Integer.MIN_VALUE, max = Integer.MIN_VALUE, ce = 0, cs = 0;

        while(ce < n) {
            if(curr <= 0) {
                curr = arr[ce];
                cs = ce;
            } else curr += arr[ce];

            if(curr > max) {
                max = curr;
                os = cs;
                oe = ce;
            }
            ce++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("sum -> ");
        sb.append(max + "\n");

        for(int i = os; i <= oe; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,-2,5};
        Kadane(arr, arr.length);
    }
}