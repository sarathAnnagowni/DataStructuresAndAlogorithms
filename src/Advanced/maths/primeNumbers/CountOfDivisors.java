package Advanced.maths.primeNumbers;

import java.util.ArrayList;

public class CountOfDivisors {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int a:A){
            ans.add(getDivisorCount(a));
        }
        return ans;
    }

    public int getDivisorCount(int A) {
        int count = 0;
        if(A ==1 ) return 1;
        for(int i=1;i<=A/i;i++){
            if(A%i==0){
                if(A/i == i){
                    count=count+1;
                }
                else{
                    count=count+2;
                }

            }
        }
        return count;
    }
}
