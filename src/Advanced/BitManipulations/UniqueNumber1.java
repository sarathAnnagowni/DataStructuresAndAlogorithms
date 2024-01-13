package Advanced.BitManipulations;

public class UniqueNumber1 {

    public static void main(String[] args) {
        int[] arr={2,2,2,1,1,1,4,4,4,3,3,3,6};
        System.out.println(getUniqueNumber(arr));

    }

    static int getUniqueNumber(int[] arr){
        int ans =0;
        //find the each position bit count
        int diffBit = 0;
        for(int i=0;i<32;i++){
            int count =0;
            for(int a : arr){
                if(checkBit(a,i)){
                    count++;
                }
            }
            if(count % 3 !=0){
                diffBit = i;
                ans = ans | 1<<i;
            }
        }

        return ans;
    }
    private  static boolean checkBit(int A,int i){
        return (A & (1 << i)) == 1 << i;
    }
}
