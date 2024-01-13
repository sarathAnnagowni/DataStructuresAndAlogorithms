package Advanced.hashing;

import java.util.*;

public class Hashing1 {

    public static void main(String[] args) {
        Hashing1 h=new Hashing1();
        ArrayList<Integer> input=new ArrayList<>();
        input.add(10);
        input.add(5);
        input.add(3);
        input.add(4);
      /*  input.add(3);
        input.add(5);
        input.add(6);*/
        System.out.println(h.firstRepeatingElement(input));
    }
    public ArrayList<Integer> frequencyOfElementQuery(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        ArrayList<Integer> ans= new ArrayList<>();
        for(Integer a : A){
            if(hashMap.containsKey(a)){
                hashMap.put(a,hashMap.get(a)+1);
            }else{
                hashMap.put(a,1);
            }
        }
        for(Integer b: B){
            if(hashMap.containsKey(b)){
                ans.add(hashMap.get(b));
            }else{
                ans.add(0);
            }
        }
       return  ans;
    }
    public int countDistinctElements(ArrayList<Integer> A) {
        Set<Integer> set=new HashSet<>();
        for(int a : A){
            set.add(a);
        }
        return set.size();
    }

    //10,5,3,4,3,5,6
    public int firstRepeatingElement(ArrayList<Integer> A) {
        Map<Integer,Integer> map=new HashMap<>();
        int ansIndex=A.size();
        for(int i=0;i<A.size();i++){
            int ele=A.get(i);
         if(map.containsKey(ele)){
             int insertedKeyPosition=map.get(ele);
             ansIndex=Math.min(insertedKeyPosition,ansIndex);
         }else{
             map.put(ele,i);
         }
        }
        return ansIndex == A.size() ? -1:A.get(ansIndex);
    }
    }
