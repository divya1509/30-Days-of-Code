// Ques - Find the Duplicate Number
// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and uses only constant extra space.

// Example 1:
// Input: nums = [1,3,4,2,2]
// Output: 2

// Example 2:
// Input: nums = [3,1,3,4,2]
// Output: 3

import java.util.*;
class q6 {

    //linkedlist find loop in wala logic hai
    public static int findDuplicate(int[] nums) {
        int turtle = nums[0], rabbit = nums[0];

        //turtle -> slow
        //rabbit -> fast
        // loop detect
        do{
            turtle = nums[turtle];
            rabbit = nums[nums[rabbit]];
        } while(turtle != rabbit);

        //find the entrance
        turtle = nums[0];
        while(turtle != rabbit) {
            rabbit = nums[rabbit];
            turtle = nums[turtle];
        }
        return turtle;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }
}