package Advanced.BitManipulations;
/*
Given an integer A, find and return the Ath magic number.

A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.

First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….

Problem Constraints
1 <= A <= 5000



Input Format
The only argument given is integer A.



Output Format
Return the Ath magic number

Example Input
Example Input 1:

 A = 3
Example Input 2:

 A = 10

 Example Output
Example Output 1:

 30
Example Output 2:

 650
 */
public class NthMagicalNumber {
    public static void main(String[] args) {
        int A=10;
        int pow = 5;
        int ans=0;
        int i=0;
        while(i < 32){
            if((A & (1<<i)) != 0){
               ans+= (int) Math.pow(pow,i+1);
            }
            i++;
        }
        System.out.println(ans);
    }
}
