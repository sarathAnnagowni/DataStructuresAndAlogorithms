package Advanced.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountPairSum {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(1);
        input.add(2);
        CountPairSum cp=new CountPairSum();
        System.out.println(cp.solve(input,3));


    }

    public int solve(ArrayList<Integer> A, int B) {
        long ans =0;
        Map<Integer,Integer> map= new HashMap<>();
        int i=0;
        int length=A.size();
        while(i<length){
            int ele = A.get(i);
            int keyToSearch = B - ele;
            if(map.containsKey(keyToSearch)){
                 int count = map.get(keyToSearch);
                 ans = ans + count;
            }
            if(map.containsKey(ele)){
                map.put(ele,map.get(ele)+1);
            }else{
                map.put(ele,1);
            }
            i++;
        }

        return (int) (ans % (Math.pow(10,9)+7));
    }

}
