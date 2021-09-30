// // Next Permutation
// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
// If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
// The replacement must be in place and use only constant extra memory.

import java.util.*;
class q3{
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void nextPermutation(int[] nums) {
        int idx = nums.length - 2;
        // find first place jaha decreasing order ni bann rha coz usko change krna best hai
        while(idx >= 0) {
            if(nums[idx] < nums[idx + 1]) {
                break;
            }
            idx--;
        }
        // System.out.println(idx);
        
        if(idx >= 0) {
            // since idx k peeche wale sare bande humesha sorted honge decreasing order mein to find aisa num jo currr num se just bada ho
            // r usse swap kr do
            int swapIdx = idx + 1;
            while(swapIdx < nums.length && nums[swapIdx] > nums[idx]) swapIdx++;
            swapIdx--;
            swap(nums, swapIdx, idx);
        }
        
        int l = idx + 1, r = nums.length - 1;
        // idx k baad wale bande decreasing order mein hai to reverse kr do sort ho jayega r next permutation ban jayega
        while(l < r) {
            swap(nums, l , r);
            l++;
            r--;
        }
        
        
    }

    public static void main(String[] args) {
        int[]  arr = {1,5,8,4,7,6,5,3,1};
        System.out.println(nextPermutation(arr));
    }
}