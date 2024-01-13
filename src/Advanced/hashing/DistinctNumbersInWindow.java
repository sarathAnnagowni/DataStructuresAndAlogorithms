package Advanced.hashing;

import java.util.HashMap;

/*
Problem Description
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Problem Constraints
1 <= N <= 106

1 <= A[i] <= 109


Input Format
First argument is an integer array A
Second argument is an integer B.



Output Format
Return an integer array.



Example Input
Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:

 A = [1, 1, 2, 2]
 B = 1


Example Output
Output 1:

 [2, 3, 3, 2]
Output 2:

 [1, 1, 1, 1]
 */
public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        int[] input={1, 1, 2, 2};
        DistinctNumbersInWindow ds= new DistinctNumbersInWindow();
        for(int a : ds.dNums(input,1) )
            System.out.print(a+" ");
    }
    public int[] dNums(int[] A, int B) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int[] ans = new int[A.length-B+1];
        for(int i=0;i<B;i++){
            if(hm.containsKey(A[i])){
                hm.put(A[i],hm.get(A[i])+1);
            }else{
                hm.put(A[i],1);
            }
        }
        ans[0]=hm.size();
        for(int i=1;i<A.length-B+1;i++){
            int removedElement=A[i-1];
            int insertElement = A[i+B-1];
            if(hm.get(removedElement) == 1){
                hm.remove(removedElement);
            }else{
               hm.put(removedElement,hm.get(removedElement)-1);
            }

            if(hm.containsKey(insertElement)){
                hm.put(insertElement,hm.get(insertElement)+1);
            }else{
                hm.put(insertElement,1);
            }
            ans[i]=hm.size();
        }
        return ans;
    }
}
