package Advanced.hashing;

import java.util.*;

/*
Given an array of integers A and an integer B.
Find the total number of subarrays having sum equals to B.


Problem Constraints
 1 <= length of the array <= 50000
-1000 <= A[i] <= 1000


Input Format
The first argument given is the integer array A.
The second argument given is integer B.


Output Format
Return the total number of subarrays having sum equals to B.


Example Input
Input 1:
A = [1, 0, 1]
B = 1

Input 2:
A = [0, 0, 0]
B = 0


Example Output
Output 1:
4
Output 2:
6

 */
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        Integer[] integerArray ={1,0,1,0,0,1,0};
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(integerArray));
        SubArraySumEqualsK subArraySumEqualsK=new SubArraySumEqualsK();
        System.out.println(subArraySumEqualsK.solve(input,1));
    }
    public int solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> prefixSum=new ArrayList<>();
        prefixSum.add(A.get(0));
        for(int i=1;i<A.size();i++){
            prefixSum.add(prefixSum.get(i-1)+A.get(i));
        }

        return counPairtDiff(prefixSum,B);
    }
    public int counPairtDiff(ArrayList<Integer> A, int B) {
        long ans =0;
        Map<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        for (Integer a: A) {
            int sea=a - B;
            if(map.containsKey(sea)){
               ans+=map.get(sea);
            }
            if(map.containsKey(a)){
                map.put(a,1+map.get(a));
            }else{
                map.put(a,1);
            }
        }

        /*Set<Integer> keySet=map.keySet();
        for (Integer ele: keySet) {
            int sea= ele-B;
            if (sea == 0) {
                ans++;
            }
            if(map.containsKey(sea)){
                ans = ans + ((long) map.get(ele) * map.get(sea));
            }
        }*/

        return (int) (ans % (Math.pow(10,9)+7));
    }
}
