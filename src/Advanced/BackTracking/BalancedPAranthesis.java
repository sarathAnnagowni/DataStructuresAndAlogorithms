package Advanced.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BalancedPAranthesis
{
    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();
        balanceParanthesis("",3,0,0,result);
        String[] resultArray = result.toArray(new String[0]);

    }
    static void balanceParanthesis(String str, int n, int openCount, int closeCount,ArrayList<String> result){
       /* if(str.length() == 2*n){
            result.add(str);
            return ;
        }else{
            System.out.println(str);
        }*/
        if(openCount > closeCount)
            balanceParanthesis(str+")",n,openCount,closeCount+1,result);
        if(openCount < n)
            balanceParanthesis(str+"(",n,openCount+1,closeCount,result);

        if(openCount>0 && openCount == closeCount){
            result.add(str);
            System.out.println(str);
        }
        //System.out.println(str);
    }
}
