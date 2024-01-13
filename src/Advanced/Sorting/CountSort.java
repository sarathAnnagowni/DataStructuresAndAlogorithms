package Advanced.Sorting;

public class CountSort {
    public static void main(String[] args) {
        CountSort cs = new CountSort();
        int[] input = {4,1,2,3,9,9};
        for(int a : cs.solve(input)){
            System.out.print(a+" ");
        }
    }

    public int[] solve(int[] A) {
        int max=0;
        for(int a : A){
            if(a>max){
                max=a;
            }
        }
        int[] freq = new int[max+1];
        int[] ans = new int[A.length];
        for(int a:A){
            freq[a]++;
        }
        int j=0;
        for(int i=0;i< freq.length;i++){
            for(int k=0;k<freq[i];k++){
                ans[j]=i;
                j++;
            }
        }
        return ans;


    }
}
