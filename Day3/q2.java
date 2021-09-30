// Pow(x, n)
// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

import java.util.*;
class q2{
    // x ^ n = x ^ (n / 2 + n / 2)
    // if n is even to vo evenly divide ho jayega but odd k case mein ek reh jayega to alag se handle krna hoga
    // n < 0 k liye sird odd power mein dhyaan dena zaroori hai ki x multiply hoga ya divide 
    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1 || x == 1) return x;
        double rec = myPow(x, n / 2);
        
        if(n % 2 == 0) return rec * rec;
        else{
            if(n > 0) return rec * rec * x;
            else return (rec * rec) / x; 
        }
    }
    
    public static void main(String[] args) {
        System.out.println(myPow(2, 5));
    }
}