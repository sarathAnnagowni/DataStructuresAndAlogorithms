package Advanced.BitManipulations;

public class MaxAndValue {
    public static void main(String[] args) {
        int[] arr = {16,9,6,13};
        System.out.println(new MaxAndValue().getMaxAndValue(arr));
    }
     int getMaxAndValue(int[] arr){
        int mask = 0;
        int result = 0;
        for(int i = 31; i>=0 ;i--){
            mask = 1<<i | result;
            int count = checkSetBits(arr,mask);
            if(count >= 2)
                result = result | mask;
        }
        return result;
    }

      int checkSetBits(int[] arr, int mask) {
        int count = 0;
        for(int a :arr){
            if((a & mask) == mask)
                count++;
        }
        return count;
     }
}
