package Advanced.maths.primeNumbers;

import java.util.ArrayList;

public class FindAllPrimes {
    public ArrayList<Integer> solve(int A) {
        int input=A;
        ArrayList<Integer> primeList = new ArrayList<>();
        boolean[] primeArray= new boolean[input+1];
        primeArray[0]=false;
        primeArray[1]=false;
        primeArray[2]=true;
        updateDivisors(2, input, primeArray);
        primeArray[3]=true;
        updateDivisors(3, input, primeArray);
        for(int i=5;i<=input;i++){
            if(primeArray[i]){
                updateDivisors(i, input, primeArray);
            }else{
                if(isPrime(i)){
                    primeArray[i]=true;
                }
                updateDivisors(i, input, primeArray);
            }
        }

        for(int i=0;i<primeArray.length;i++){
            if(primeArray[i])
                primeList.add(i);
        }
        return primeList;

    }
    public  boolean isPrime(int A) {
        int count = 0;
        if(A ==1 ) return false;
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
        return count <= 2;
    }
    private  void updateDivisors(int i, int input, boolean[] primeArray) {
        int j=2;
        while(i * j <= input){
            primeArray[i * j] = false;
            j++;
        }
    }
}
