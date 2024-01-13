public class Equilibrium {

    public static void main(String[] args) {
        int[] A={1,2,3,7,1,2,3};
        System.out.println(solve(A));
    }
    public static int solve(int[] A) {
        int[] prefixArray = new int[A.length];
        prefixArray[0]=A[0];
        for(int i=1;i<A.length;i++){
            prefixArray[i]=A[i]+prefixArray[i-1];
        }
        for (int a:prefixArray) {
            System.out.print(a+" ");
        }
        System.out.println();
        int count =0;
        for(int i=0;i<A.length;i++){
            int leftSum = i == 0 ? 0 : prefixArray[i-1];
            int rightSum = prefixArray[A.length-1] - prefixArray[i];
            System.out.println(i + " leftSum " + leftSum +" rightSum "+rightSum);
            if(leftSum == rightSum){
                count++;
            }
        }
        return count;
    }
}
