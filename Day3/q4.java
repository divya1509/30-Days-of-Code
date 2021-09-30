// Majority Element II
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
// Follow-up: Could you solve the problem in linear time and in O(1) space?

import java.util.*;
class q4 {
    // count every element n if it occurs more than n/ 3 save it as ans
    private static List<Integer> HashMapApproach(int[] nums){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums) {
            int t = 1;
            if(hm.containsKey(num)) t += hm.get(num);
            hm.put(num, t);
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int key : hm.keySet()) {
            if(hm.get(key) > nums.length / 3) ans.add(key);
        }
        return ans;
    }
    
    // moore voting algo
    // triplets bana lo elements k 
    private static List<Integer> linerTimeApproach(int[] nums) {
        int count1 = 1, count2 = 0, num1 = nums[0], num2 = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(num1 == nums[i]) count1++;
            else if(num2 == nums[i]) count2++;
            else {
                if(count1 == 0) {
                    count1++;
                    num1 = nums[i];
                } else if(count2 == 0) {
                    count2++;
                    num2 = nums[i];
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        
        
        count1 = 0;
        count2 = 0;
        
        for(int num : nums) {
            if(num == num1) count1++;
            if(num == num2) count2++;
        }
        
        // System.out.println(num1 + " " + num2);
        
        List<Integer> ans = new ArrayList<>();
        if(count1 > nums.length / 3) ans.add(num1);
        if(count2 > nums.length / 3 && num1 != num2) ans.add(num2);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(HashMapApproach(arr));
        System.out.println(linerTimeApproach(arr));
    }
}