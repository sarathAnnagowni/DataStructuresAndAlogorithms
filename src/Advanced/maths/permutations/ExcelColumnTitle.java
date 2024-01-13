package Advanced.maths.permutations;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumnTitle {
    public static void main(String[] args) {
        int a ='A';
        ExcelColumnTitle es=new ExcelColumnTitle() ;
        System.out.println(es.getExcelTitle(676));
        System.out.println(es.getExcelColumnNumber("YZ"));


    }

    public String getExcelTitle(int A){
        Map<Integer,Character> map=new HashMap<>();
        int a ='A';
        for(int i=1;i<27;i++){
            map.put(i,(char)a);
            a++;
        }
        String ans="";
        while(A!=0){
            int rem= A %26;
            A = A/26;
            if(rem==0){
                A= A-1;
                rem=26;
            }
            ans = map.get(rem) +ans;

        }
        return ans;

    }

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
