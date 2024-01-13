public class Main {
    public static long[] rangeSum(int[] A, int[][] B) {
        long[] prefixArray=new long[A.length];
        prefixArray[0]=A[0];
        for(int i=1;i<A.length;i++){
            prefixArray[i]=A[i]+prefixArray[i-1];
        }
        long[] rangeSum=new long[B.length];
        for(int i=0;i<B.length;i++){
            int L=B[i][0];
            int R=B[i][1];
            if(L==0){
                rangeSum[i]=prefixArray[R];
            }
            else{
                rangeSum[i]=prefixArray[R]-prefixArray[L-1];
            }
        }
        return rangeSum;
    }
    public static void main(String[] args){
        //System.out.println("hello");
       // int[] a={7,3,1,5,5,5,1,2,4,5};
        int[] x={2,4};
        int[] y={3,6};
        int[] z={4,8};
        int[][] matrix=new int[3][3];
        x= new int[3];
        x[0]=1;
        x[1]=2;
        matrix[0] = x;
        x= new int[3];
        x[0]=2;
        x[1]=4;
        matrix[1] = x;
        x= new int[3];
        x[0]=3;
        x[1]=6;
        matrix[2] = x;
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }


    }
}