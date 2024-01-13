package Advanced.arrays;

public class FirstMissingInteger {
    public static void main(String[] args) {
        int[] A = {2,3,1,6,4};
        System.out.println(firstMissingPositive(A));
    }
    public static int firstMissingPositive(int[] A) {
        int N = A.length;
        for(int i=0;i<N;i++){
            int element = A[i];
            if(A[i] > 0 && A[i]<=N){
                if(A[i]!=i+1 && A[element-1]!=element){
                    swap(A, i, element);
                    i--;
                }
            }
        }

        for(int i=0 ; i < N ; i++){
            if(A[i]!= i+1)
                return i+1;
        }

        return N+1;
    }

    private static void swap(int[] A, int i, int element) {
        int temp= A[i];
        A[i] = A[element -1];
        A[element -1] = temp;
    }
}
