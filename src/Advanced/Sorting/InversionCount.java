package Advanced.Sorting;

public class InversionCount {
    public static void main(String[] args) {
        int[] input = {3, 4, 1, 2};
        InversionCount ic = new InversionCount();
        System.out.println(ic.solveBruteForce(input));

    }

    public int solveBruteForce(int[] A) {
        long ans=0;
        for(int i=0;i<A.length-1;i++){
            for(int j=i+1;j<A.length;j++){
                if(A[i] > A[j]){
                    ans++;
                }
            }
        }
        return (int) (ans%(Math.pow(10,9)+7));
    }

}
