import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinMax {
    public static void main(String[] args) {
        /*int[][] a={{1,2,3},{4,5,6},{7,8,9}};

        //transpose of a matrix
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a[0].length;j++){
                int temp=a[i][j];
                 a[i][j]=a[j][i];
                  a[j][i]=temp;
            }
        }
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

       // Arrays.sort(a);
       *//* System.out.println("829496470932889354");
        System.out.println(Long.MAX_VALUE);
        System.out.println("27739313582448394");
       *//*
       *//* int[][] b= diagonal(a);
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }*//*
*/
    }
    public void rotateMatrix(int[][] A) {
        int m=A.length;
        int n=A[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int temp=A[i][j];
                A[i][j]=A[j][i];
                A[j][i]=temp;
            }
        }

        //reverse colums

        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                int temp=A[i][j];
                A[i][j]=A[i][n-1-j];
                A[i][n-1-j]=temp;
            }
        }


    }
    public static int[][] diagonal(int[][] A) {
        int row=A.length;
        int col=A[0].length;
        int[][] ans=new int[row+col-1][col];

        int k =0;
        for(int j=0;j<col;j++){
            int r=0; int c=j;
            int[] arr=new int[col-1];
            while(r < row && c >=0){
               // System.out.print(A[r][c]+" ");
                arr[r]=A[r][c];
                r++;
                c--;
            }
            ans[k]=arr;
            k++;
            System.out.println();

        }

        for(int i=1;i<row;i++ ){
            int r=i ;int c=col-1;
            int[]  arr=new int[col-1];
            int idx=0;
            while(r< row && c >=0){
               // System.out.print(A[r][c]+ " ");
                arr[idx]=A[r][c];
                r++;
                c--;
                idx++;
            }
           // System.out.println();
            ans[k]=arr;
            k++;
        }
return ans;

    }
    public static int minAvgSubArray(int[] A, int B) {
        if(B>A.length){
            return 0;
        }
        for(int i=1;i<A.length;i++){
            A[i]=A[i]+A[i-1];
        }
        double minAvg=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0,j=B-1;i<A.length-B+1;i++,j++){
            int sum = 0;
            if(i==0){
                sum = A[j];
            }else{
                sum  = A[j]-A[i-1];
            }
            double avg= (double) sum /B;
            if(avg < minAvg){
                minAvg = avg;
                ans=i;
            }

        }
        return ans;
    }

    public static int minSwap(int[] A, int B) {
        int b=0;
        for(int i=0;i<A.length;i++){
            if(A[i]>B){
                b=i;
                break;
            }
        }
        int count=0;
        while(b<A.length){
            if(A[b] < B){
                count++;
            }
            b++;
        }
        return count;
    }
    public static long subarraySum(int[] A) {
        int n=A.length;
        long sum=0;
        for(int i=0;i<n;i++){
            long c= (long) (i + 1) *(n-i);
            sum=sum+A[i]*c;
        }
        return sum;
    }
    public static int subArraySumLessThanX(int[] A, int B) {
        int[] prefixSum=new int[A.length];
        prefixSum[0]=A[0];
        for(int i=1;i<A.length;i++){
            prefixSum[i]=prefixSum[i-1]+A[i];
        }
        int count=0;
        for(int i=0;i<A.length;i++){
            for(int j=i;j<A.length;j++){
                int sum=0;
                if(i==j){
                    sum=A[j];
                }
                if(i==0){
                    sum=prefixSum[j];
                }else{
                    sum =prefixSum[j] - prefixSum[i-1];
                }
                if(sum < B){
                    count++;
                }

            }
        }
        return count;
    }
    public int equalSubArray(int[] A, int B, int C) {
        int size=A.length;
        for(int i=1;i<size;i++){
            A[i]=A[i]+A[i-1];
        }
        if(B==size){
            if(A[size-1]==C){
                return 1;
            }else {
                return 0;
            }
        }
        for(int i=0,j=B-1;j<size;i++,j++){
            int sum=0;
            if(i==0){
                sum = A[j];
            }else{
                sum=A[j]-A[i-1];
            }
            if(sum==C){
                return 1;
            }
        }
        return 0;

}

    public static int maxSubarray(int A, int B, int[] C) {
        int[] prefixSum=new int[A];
        prefixSum[0]=C[0];
        for(int i=1;i<A;i++){
            prefixSum[i]=prefixSum[i-1]+C[i];
        }
        int maxSum=0;
        for(int i=0; i<A;i++){
            int sum=0;
            for(int j=i;j<A;j++){
                if( i==0 ){
                    sum = prefixSum[j] ;
                } else{
                    sum = prefixSum[j]-prefixSum[i-1];
                }
                if( sum >= maxSum && sum <= B) {
                    maxSum = sum;
                }
            }


        }
        return maxSum;
    }
           public static int solveMaxRangeSubArray(int[] A, int B) {
            int size=A.length;
            for(int i=1;i<size;i++){
                A[i]=A[i]+A[i-1];
            }

            int maxSum=Integer.MIN_VALUE;
            if(B==size){
                maxSum=A[size-1];
            }
            for(int i=B-1,j=0;j<=B;i--,j++){
                if(j!=0){
                    int sum=0;
                    if(i>=0){
                         sum=A[i]+A[size-1]-A[size-1-j];
                    }else{
                        sum=A[size-1]-A[size-1-j];
                    }
                    maxSum=Math.max(sum,maxSum);
                }else{
                    int sum=A[i];
                    maxSum=Math.max(sum,maxSum);
                }

            }

            return maxSum;

        }




    public static int[] solveLeader(int[] A) {
        int[] res= new int[A.length];

        int k=0;
        for(int i=0;i<A.length-1;i++){
            if(isLeader(A,i)){
                res[k]=A[i];
                k++;
            }

        }
        //l.add(A[A.length-1]);
        res[k]=A[A.length-1];
        return res;

    }
    public  static boolean isLeader(int[] A,int L){
        for(int i=L+1;i<A.length;i++){
            if (A[L]<A[i]) {
                return false;
            }
        }
        return  true;

    }
    public static int[] solve(int[] A, int B, int C) {
        int length=C-B+1;
        int[] sArray=new int[length];
        for(int i=0;i<length;i++){
            sArray[i]=A[B-i];
        }
        return sArray;
    }
    public static int[][] solveIt(int[] A) {
        int length=A.length*A.length;
        int[][] res=new int[length][1];
        int l=0;
        for(int i=0;i<A.length;i++){
            for(int j=i;j<A.length;j++){
                int[]  sArr = generateSubArray(A,i,j);
                res[l]=new int[sArr.length];
                for(int u=0;u<sArr.length;u++){
                   res[l][u]=sArr[u];
                }
                l++;
            }

        }
        return res;
    }
    public static int[] generateSubArray(int[] A, int B, int C) {
       // System.out.println("B   "+B+" C  "+B);
        int minIndex=0;
        int length=0;
        if(C>B){
           length=C-B+1;
            minIndex=B;
        }else if(B>C){
            length=B-C+1;
            minIndex=C;
        }else{
            length=1;
            minIndex=B;
        }
        int[] sArray=new int[length];
        for(int i=0;i<length;i++){
            sArray[i]=A[minIndex+i];
        }
        return sArray;
    }
    public static int solve(int[] A) {
        int min=A[0];
        int max=A[0];
         int minIndex=0,maxIndex=0;

        for(int i=0;i<A.length;i++){
            if(A[i] < min){
                min=A[i];
                minIndex=i;
            }
            if(A[i]>max){
                max=A[i];
                maxIndex=i;
            }
        }


        if(min==max){
            return 1;
        }
        int ans=A.length;
        for(int i=0;i<A.length;i++){
            if(A[i]==min){
               minIndex=i;
               ans=Math.min(ans,Math.abs(maxIndex-minIndex)+1);
            }
            if(A[i]==max){
                maxIndex=i;
                ans=Math.min(ans,Math.abs(maxIndex-minIndex)+1);
            }
        }
        return ans;
    }
}
