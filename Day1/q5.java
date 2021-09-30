// Ques - Merge Intervals
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
// and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6]. 

import java.util.*;

class q5{
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        //start end ko alag se sort krna is ok coz konsa event start and end hua is not important at all
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        ArrayList<int[]> arr = new ArrayList<>();
        int cs = 0, ce = 0;
        while(ce < n) {
            if(ce + 1 < n && start[ce + 1] <= end[ce]) {
                //do nothing
            }
            else {
                // present end_time < next start_time to create interval

                int[] temp = new int[2];
                temp[0] = start[cs];
                temp[1] = end[ce];
                arr.add(temp);
                cs = ce + 1;
            }
            ce++;
        }
        
        int[][] ans = new int[arr.size()][2];
        for(int i = 0; i < arr.size(); i++) {
            ans[i][0] = arr.get(i)[0];
            ans[i][1] = arr.get(i)[1];
        }
        return ans;
    }

    private static void display(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append("[" + arr[i][0] + " " + arr[i][1] + "] ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge(arr);
        display(ans);
    }
}