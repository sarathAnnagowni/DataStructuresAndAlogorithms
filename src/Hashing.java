import java.awt.*;
import java.util.*;

public class Hashing {
    public static void main(String[] args) {
       Hashing hashing = new Hashing();
      System.out.println(hashing.anagrams("cat","caat"));

    }
    public int repeatedNumber(int[] A) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<A.length;i++){
            if(map.containsKey(A[i])){
                map.put(A[i],map.get(A[i])+1);
            }else{
                map.put(A[i],1);
            }
        }

        for(Integer a : map.keySet()){
            int count= map.get(a);
            if(count > A.length / 3) return a;
        }
        return -1;
    }

    public int anagrams(String A, String B) {
        char[] a=A.toCharArray();
        Arrays.sort(a);
        char[] b=B.toCharArray();
        Arrays.sort(b);
        return new String(a).equals(new String(b))?1:0;

    }

    public int[] commonElements(int[] A, int[] B) {
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();
        pushElementsToMapWithCount(hm1,A);
        pushElementsToMapWithCount(hm2,B);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer k:hm1.keySet()) {
            if(hm2.containsKey(k)){
                int count1=hm1.get(k);
                int count2=hm2.get(k);
                int min=Math.min(count1,count2);
                for(int i=0;i<min;i++){
                    arrayList.add(k);
                }
            }
        }
        int[] ans=new int[arrayList.size()];
        for (int i = 0; i < ans.length ; i++) {
            ans[i]=arrayList.get(i);
        }
        return  ans;

    }
    public void pushElementsToMapWithCount(HashMap<Integer,Integer> map,int[] array){
        for (Integer a : array) {
            if(map.containsKey(a)){
              map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }

    }
    public int colorful(int A) {
        int l=(A+"").length();
        int[] a=new int[l];
        HashMap<Integer,Integer> hm=new HashMap<>();

        int k=0;
        while(A>0){
            int r=A%10;
            A=A/10;
            a[k]=r;
            if(hm.containsKey(r) || r==0 || r==1){
                return 0;
            }else{
                hm.put(r,r);
            }
            k++;
        }
        HashMap<Integer,Integer> sumMap=new HashMap<>();
        for(int i=0;i<a.length;i++){
            int sum=1;
            for(int j=i;j<a.length;j++){
                sum=a[j] *sum;
                if(sumMap.containsKey(sum)){
                    return 0;
                }else{
                    sumMap.put(sum,sum);
                }
            }

        }

        return 1;
    }
    public static int[][] rowWithZero(int[][] A) {
        HashSet<Integer> cols=new HashSet<>();
        HashSet<Integer> rows=new HashSet<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(rows.contains(i) || cols.contains(j)){
                  A[i][j]=0;
                }
            }
        }
        return A;
    }


    public String addBinary(String A, String B) {
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        int ansLength=a.length > b.length ? a.length+1 : b.length+1;
        char[] ans=new char[ansLength];
        int k = ansLength-1;
        int i=a.length-1;
        int j=b.length-1;
        int carry=0;
        ans[0]='0';
        while(i>=0 || j>=0 || carry > 0){
            int x = i >= 0 ? a[i]-'0' : 0;
            int y= j >= 0 ? b[j]-'0' : 0;
            int z='0'+ ((x+y+carry) % 2);
            carry = (x+y+carry ) /2;
            ans[k]=(char)z;
            i--;j--;k--;
        }
        return ans[0]!='0'? new String(ans) :new String(ans,1,ans.length-1);

    }
    public int solve(int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        for(int a : A){
            hs.add(a);
        }
        return hs.size();
    }
    public int[] eleCount(int[] A, int[] B) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for (int a: A) {
            if(hm.get(a)==null){
                hm.put(a,1);
            }else{
                hm.put(a,hm.get(a)+1);
            }
        }
        int[] ans=new int[B.length];
        for (int i = 0; i < B.length; i++) {
            ans[i]=hm.get(B[i]) !=null ? hm.get(B[i]) :0;
        }
        return ans;
    }
}
