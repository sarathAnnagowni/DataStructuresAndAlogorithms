package Advanced.BitManipulations;

public class SingleNumberIII {
    public static void main(String[] args) {
       int[] A={2,3,4,3,6,4};
       printUniqueNumbers(A);
    }
    static int[] printUniqueNumbers(int[] A){

        int i=0;
        int[] x=new int[2];
        int unique1=0,unique2 =0;
        while(i<32){
            int count =0;
            for(int a : A){
                if ( checkBit(a,i) )
                    count++;
            }
            if((count % 2) !=0){
                for(int a : A){
                    if( checkBit(a,i) ){
                        x[0] = x[0] ^ a;
                    }else{
                        x[1] = x[1] ^ a;
                    }
                }
                break;
            }
            i++;
        }
        return x;

    }

    private  static boolean checkBit(int A,int i){
        return (A & (1 << i)) == 1 << i;
    }


}
