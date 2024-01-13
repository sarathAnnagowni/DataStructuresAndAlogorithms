public class Solve {
    public static int solve(int[] A) {
        int count=0;
        int[] evenSumPrefix=buildPrefixSumForEvenOrOdd(A,true);
        int[] oddSumPrefix=buildPrefixSumForEvenOrOdd(A,false);
        for(int i=0;i<A.length;i++){
            int l=i;
            int r=A.length;
            int evenSum = i==0 ? oddSumPrefix[r-1]: evenSumPrefix[i-1]+oddSumPrefix[r-1]-oddSumPrefix[i];
            int oddSum = i==0? evenSumPrefix[r-1] : oddSumPrefix[i-1]+evenSumPrefix[r-1]-evenSumPrefix[i];
            if(evenSum == oddSum){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A={3,6,8,9,-3,4,7};
        int[] evenSumPrefix=buildPrefixSumForEvenOrOdd(A,true);
        int[] oddSumPrefix=buildPrefixSumForEvenOrOdd(A,false);
        for (int a: evenSumPrefix) {
         System.out.print(a+" ");
        }
        System.out.println("+++++++++++++++++");
        for (int a: oddSumPrefix) {
            System.out.print(a+" ");
        }

        System.out.println();
        System.out.print(solve(A));
    }
    public static int[] buildPrefixSumForEvenOrOdd(int[] A,boolean isEven){
        int[] prefixArray = new int[A.length];
        if(isEven){
            for(int i=0;i<A.length;i++){
                if(i==0){
                    prefixArray[i]=A[i];
                    continue;
                }
                if(i%2==0){
                    prefixArray[i]=prefixArray[i-1]+A[i];
                }else{
                    prefixArray[i]=prefixArray[i-1];
                }
            }
        }else{
            for(int i=0;i<A.length;i++){
                if(i==0){
                    prefixArray[i]=0;
                    continue;
                }
                if(i%2!=0){
                    prefixArray[i]=prefixArray[i-1]+A[i];
                }else{
                    prefixArray[i]=prefixArray[i-1];
                }
            }

        }
        return prefixArray;
    }
}
