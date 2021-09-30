// Pascal's Triangle
// Given an integer numRows, return the first numRows of Pascal's triangle.

import java.util.*;
class q2{

    // use nCr = n! / (n - r)! * (r)!
    // find nC(r + 1) using pre-existing nCr -> nC(r+1) = nCr * (n - r) / (r + 1) 
    public static List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            int ncr = 1;
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                temp.add(ncr);
                ncr = ncr * (i - j) / (j + 1) ;
            }
            ans.add(temp);
        }
        return ans;
        
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(generate(n));
    }
}