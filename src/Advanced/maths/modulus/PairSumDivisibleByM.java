package Advanced.maths.modulus;

public class PairSumDivisibleByM {
    public static void main(String[] args) {
      int[] A={93,9,46,79,56,24,10,26,9,93,31,93,75,7,4,80,19,67,49,84,62,100,17,40,35,84,14,81,99,31,100,66,70,2,11,84,60,
              89,13,57,47,60,59,60,42,67,89,29,85,83,42,47,66,80,88,85,83,82,16,23,21,55,26,2,21,92,85,26,46,3,7,95,50,22,84,52,57,44,4,23,25,55,41,49};
      int ans =new PairSumDivisibleByM().solve(A,37);
      ans = (int) (ans% (Math.pow(10,9)+7));
        System.out.println(ans);
    }

    public int solve(int[] A, int B) {
        int[] modulusArray = new int[B];
        int mod = 1000000007;
        for(int a : A){
            int modulus = a % B;
            modulusArray[modulus] = modulusArray[modulus]+1;
        }
        long ans = 0;
        int zeroCount = modulusArray[0];
        if(zeroCount > 1){
            ans = getNC2(zeroCount);
            ans = ans % mod;
        }

        int i=1;
        int j=B-1;
        while(i<=j){
            if(i==j){
                ans = ans + getNC2(modulusArray[i]);
            }else{
                ans = ans + (modulusArray[i] * modulusArray[j]);
            }
            ans = ans % mod;
            i++;
            j--;
        }
        return (int)ans% mod;
    }

    private  int getNC2(int zeroCount) {
          int mod = 1000000007;
          int  temp =  zeroCount * (zeroCount-1) / 2;
          return temp % mod;
    }
}
