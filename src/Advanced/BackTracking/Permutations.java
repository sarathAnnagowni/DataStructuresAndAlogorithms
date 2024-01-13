package Advanced.BackTracking;

import java.util.Arrays;

public class Permutations {
    public static void main(String[] args) {
        char[] arr={'b','a','c'};
        Arrays.sort(arr);
        boolean[] visited=new boolean[arr.length];
        char[] ans=new char[arr.length];
        printPermutation(0,arr,visited,ans);

    }
    //what character are used
    //what is index we are going to fill
    //ans to hold
    public static void printPermutation(int idx,char[] givenCharSet,boolean[] visited,char[] ans){

        if(idx == givenCharSet.length){
            System.out.println(new String(ans));
        }else{
            for(int i=0;i<givenCharSet.length;i++){
                if(!visited[i]){
                    visited[i]=true;
                    ans[idx]=givenCharSet[i];
                    printPermutation(idx+1,givenCharSet,visited,ans);
                    visited[i]=false;
                }
            }
        }


    }
}


