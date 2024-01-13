package Advanced.Sorting;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] a={1,5,8,11};
        int[] b={2,4,7,15,21};
        MergeTwoSortedArrays m=new MergeTwoSortedArrays();
        for(int x : m.solve(a,b)){
            System.out.print(x+" ");
        }

    }
    public int[] solve(final int[] A, final int[] B) {
        int X=A.length;
        int Y=B.length;
        int[] ans=new int[X+Y];
        int k=0;int i=0;int j=0;
        while( i<X && j<Y){
            if(A[i]<=B[j]){
                ans[k]=A[i];
                i++;
            }else{
                ans[k]=B[j];
                j++;
            }
            k++;
        }
        while(i<X){
            ans[k]=A[i];
            i++;
            k++;
        }
        while(j<Y){
            ans[k]=B[j];
            j++;
            k++;
        }
        return ans;
    }


}
