// Best Time to Buy and Sell Stock
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

import java.util.*;
class q5{
    // find point jagha min price tha array mein n uske baad kam badha vo price
    public int maxProfit(int[] prices) {
        int ans = 0, min = Integer.MAX_VALUE;
        
        for(int price : prices) {
            min = Math.min(min, price);
            ans = Math.max(ans, price - min);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[]  arr = {1,5,8,4,7,6,5,3,1};
        System.out.println(maxProfit(arr));
    }
}