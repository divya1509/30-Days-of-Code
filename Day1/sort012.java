// Ques- SORT 0, 1, 2 (inplace)
// Given an array A[] consisting 0s, 1s and 2s. 
// The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.

import java.util.*;
class sort012{

    private static void countApproach(int[] arr) {
        //count the no of ones twos and zeros and traverse again to set values
        //T = O(n) (2 traversals)
        //S = O(1)

        int zero = 0, one = 0, two = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) zero++;
            else if(arr[i] == 1) one++;
            else two++;
        } 

        int idx = 0;
        while(zero-- > 0) {
            arr[idx] = 0;
            idx++;
        }

        while(one-- > 0) {
            arr[idx] = 1;
            idx++;
        }

        while(two-- > 0) {
            arr[idx] = 2;
            idx++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void optimize(int[] arr) {
        //divide array in parts 
        // 0 .... i -> contains 0
        // i .... j -> contains 1
        // j .... k -> contains 2
        // k .... n -> unexplored area

        // T = O(N) (single tarversal)
        // S = O(1)

        int i = 0, j = 0, k = 0;

        while(k < arr.length) {
            if(arr[k] == 1) {
                swap(arr, j, k);
                j++;
            } else if(arr[k] == 0) {
                swap(arr, j, k);
                swap(arr, i, j);
                i++;
                j++;
            }
            k++;
        }
    }

    private static void display(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,1,2,2,2,0,1};
        // countApproach(arr);
        optimize(arr);
        display(arr);
    }
}