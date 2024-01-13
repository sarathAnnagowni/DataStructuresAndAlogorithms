package Advanced.BackTracking;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1); A.add(2); A.add(3);
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        Integer[] input = A.toArray(new Integer[0]);
        subset(input,0,new ArrayList<>(),ans);
        System.out.println(ans.size());

        for (ArrayList<Integer> an: ans) {
            System.out.println(an);
        }

    }
    static void subset(Integer[] inp, int index, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> ansList){
        if(index == inp.length){
            System.out.println(ans);
            ArrayList<Integer> an = new ArrayList<>(ans);
            ansList.add(an);
        }
        else{
            ans.add(inp[index]);
            subset(inp,index+1,ans,ansList);
            ans.remove(ans.size()-1);
            subset(inp,index+1,ans,ansList);


        }
    }
}
