// Ques -
// Given an unsorted array of size n. Array elements are in the range from 1 to n.
//  One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.
// Examples: 

//  Input: arr[] = {3, 1, 3}
// Output: Missing = 2, Repeating = 3
// Explanation: In the array, 
// 2 is missing and 3 occurs twice 

// Input: arr[] = {4, 3, 6, 2, 1, 1}
// Output: Missing = 5, Repeating = 1

import java.util.*;
class q2{
    private static int[] extraSpace(int[] arr, int n) {

        //dp jaisa bana lo r fi uspe irrate kr k dekh lo kose idx pe vis kr chuke hai
        // jispe dubara aaye hai vo repeat hua r jispe kabhi ni gye vo missing
        
        //  T = O(n);
        //  S = O(n);

        boolean[] vis = new boolean[n];
        int[] ans = new int[2];
        for(int i = 0; i < n; i++) {
            if(vis[arr[i] - 1]) ans[0] = arr[i];
            vis[arr[i] - 1] = true;
        }
        
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                // System.out.println("here");
                ans[1] = i + 1;
            }
        }
        return ans;
        
    }

    private static int[] constantSpace(int[] arr, int n) {
        // same as extra space bas diff ye hai ki isi array ko hamne visisted ki tarha use kiya hai
        //  value < 0 -> visited 
        // value > 0 -> unvisited
        //  T = O(N)
        //  S = O(1)

        int[] ans = new int[2];
        for(int i = 0; i < n; i++) {
            int curr = Math.abs(arr[i]);
            if(arr[curr - 1] > 0) {
                arr[curr - 1] = -arr[curr - 1];
            } else ans[0] = curr;
        }

        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {
                ans[1] = i + 1;
                break;
            }
        }
        return ans;
    }

    private static void display(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,7,3,3,2,6};
        int[] ans;
        // ans = extraSpace(arr, 8);
        ans = constantSpace(arr, 8);
        display(ans);
    }
}