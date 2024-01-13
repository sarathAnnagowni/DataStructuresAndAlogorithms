package Advanced.Sorting;

public class FormSmallestElement {
    public static void main(String[] args) {
        int[] input = {4,1,2,3,9,9};
        FormSmallestElement formSmallestElement = new FormSmallestElement();
        System.out.println("Smallest Element");
        for(int a : formSmallestElement.getSmallestElement(input,10)){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("Largest Element");
        for(int a : formSmallestElement.getLargestElement(input)){
            System.out.print(a+" ");
        }
    }

    public int[] getSmallestElement(int[] input,int size){
        int[] freq=new int[10];
        int[] ans = new int[size];
        for(int a:input){
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

    public int[] getLargestElement(int[] input){
        int[] freq=new int[10];
        int[] ans = new int[input.length];
        for(int a:input){
            freq[a]++;
        }
        int j=0;
        for(int i=freq.length-1;i>=0;i--){
            for(int k=0;k<freq[i];k++){
                ans[j]=i;
                j++;
            }
        }
        return ans;
    }
}
