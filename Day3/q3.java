// Majority Element
// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

import java.util.*;
class q3{
    // moore's voting algo
    public static int majorityElement(int[] nums) {
        int sus = nums[0], count = 1;
        for(int i =1; i < nums.length; i++) {
            if(count == 0) sus = nums[i];
            
            if(sus == nums[i]) {
                count++;
            } else count--;
        }
        return sus;
    }
    public static void main(String[] args) {
        int[]  arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
}