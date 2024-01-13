package Advanced.maths.primeNumbers;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumnNumber {

    public int getExcelColumnNumber(String A){
        int ans=0;
        Map<Character,Integer> map=new HashMap<>();
        int a ='A';
        for(int i=1;i<27;i++){
            map.put((char)a,i);
            a++;
        }

        char[] s =A.toCharArray();
        int n=s.length-1;
        for(int i=n;i>=0;i--){
            ans= (int) (ans + map.get(s[i]) * Math.pow(26,n-i));
        }

        return ans;
    }
}
