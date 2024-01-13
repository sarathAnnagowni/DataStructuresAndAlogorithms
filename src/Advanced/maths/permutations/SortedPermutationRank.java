package Advanced.maths.permutations;

import java.util.*;

public class SortedPermutationRank {
    public static void main(String[] args) {

        SortedPermutationRank spr = new SortedPermutationRank();
        System.out.println(spr.fact(3));;
        System.out.println(spr.findRank("gTFAMYjxCewRlftmGOKJHUuhSBVDZnbqyoPQadEkLrpNsv"));;
    }

    public int findRank(String A) {
        char[] arr = A.toCharArray();
        int n=arr.length;
        long rank =1;
        for(int i=0;i<n;i++){
            int count =0;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[i]){
                    count++;
                }
            }
            rank+= (long) (count*(fact(n-i-1)%1000003));
        }
        return (int) (rank%1000003);
    }

    private long fact(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 0)
        {
            return 1;
        }

            return (i*fact(i-1))%1000003;
    }

    public void   printPermutation(int idx, char[] givenCharSet, boolean[] visited, char[] ans,ArrayList<String> ansList) {
        if (idx == givenCharSet.length) {
            ansList.add(new String(ans));
        } else {
            for (int i = 0; i < givenCharSet.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    ans[idx] = givenCharSet[i];
                    printPermutation(idx + 1, givenCharSet, visited, ans, ansList);
                    visited[i] = false;
                }
            }

        }

    }
}
