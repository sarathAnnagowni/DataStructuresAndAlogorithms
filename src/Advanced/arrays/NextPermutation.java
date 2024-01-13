package Advanced.arrays;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] A = {3,2,1};
        np.nextPermutation(A);
        for (int a: A) {
            System.out.print(a + "  ");
        }
    }
    public int[] nextPermutation(int[] A){
        //find the element place from right to left which breaks the property
        int swapIndex=getSwapIndex(A);
        int length = A.length;
        if(swapIndex < 0){
           reverseArray(A,0,length-1);
        }else{
            int nextLargerElement = getNextLargerElement(A,swapIndex);
            int temp = A[swapIndex];
            A[swapIndex] = A[nextLargerElement];
            A[nextLargerElement] = temp;
            reverseArray(A,swapIndex+1,length-1);
        }
        return A;
    }

    private int getNextLargerElement(int[] a, int swapIndex) {
        int index=a.length-1;
        while(index > swapIndex){
            if(a[swapIndex]<a[index]){
                return index;
            }
            index--;
        }
        return 0;
    }

    private int getSwapIndex(int[] a) {
        int index = a.length-1;
        int answer = -1;
        while(index > 0){
            if(a[index] > a[index-1]){
                answer = index-1;
                break;
            }
            index--;
        }
        return answer;
    }

    private void reverseArray(int[] a, int start, int end){
        while(start < end){
            int temp= a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
}
