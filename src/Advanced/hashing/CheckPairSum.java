package Advanced.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CheckPairSum {
    /*
     A = 8
     B = [3, 5, 1, 2, 1, 2]
     */
    public static void main(String[] args) {

    }

    public int solve(int A, ArrayList<Integer> B) {
        int ans = 0;
        Set<Integer> hashset = new HashSet<>();
        int n=B.size();
        int i=0;
        while(i < n){
            int ele = B.get(i);
            int diff= A - ele;
            if(hashset.contains(diff)){
                return 1;
            }else{
                hashset.add(ele);
            }
         i++;
        }
        return ans;

    }
}
