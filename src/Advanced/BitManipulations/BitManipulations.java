package Advanced.BitManipulations;

public class BitManipulations {
    public static void main(String[] args) {
        System.out.println(noOfSetBitsWithKerninghanAlog(15));
        System.out.println(noOfSetBits(15));

    }
    private static int noOfSetBits(int A){
        int ans=0;
        while(A > 0){
            if ((A&1) ==1){
                ans++;
            }
            A=A>>1;
        }
        return ans;
    }

    public static int noOfSetBitsWithKerninghanAlog(int A){
        int ans=0;
        while(A > 0){
            A = A & (A-1);
            ans++;
        }
        return ans;
    }
    private  static boolean checkBit(int A,int i){
        return (A & (1 << i)) == 1 << i;
    }

    private static int setBit(int A,int B){
        return  A | 1 << B;
    }

    private static int unSetBit(int A,int B){
        return checkBit(A,B) ? A ^ 1<<B : A;
    }
}
