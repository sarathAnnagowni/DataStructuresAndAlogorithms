package Advanced.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SubsetDemo {
    public static void main(String[] args) {
        SubsetDemo subsetDemo = new SubsetDemo();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(12); A.add(13);
        Integer[] input = A.toArray(new Integer[0]);
        ArrayList<ArrayList<Integer>> ans = subsetDemo.subsets(A);
        System.out.println(ans.size());

        for (ArrayList<Integer> an: ans) {
            System.out.println(an);
        }

    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        Collections.sort(A);
        Integer[] input = A.toArray(new Integer[0]);
        subset(input,0,new ArrayList<>(),ans);

        return ans;
    }
    void subset(Integer[] inp, int index, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> ansList){
        if(index == inp.length){
            ArrayList<Integer> an = new ArrayList<>(ans);
            ansList.add(an);
            return;
        }
        else{


            ans.add(inp[index]);
            subset(inp,index+1,ans,ansList);
            ans.remove(ans.size()-1);
            subset(inp,index+1,ans,ansList);


        }
    }
}
