package Advanced.BitManipulations;

public class StrangeEquality {
    public static void main(String[] args) {
        StrangeEquality se = new StrangeEquality();
        System.out.println(se.strangeEqual(8));
    }

    public int strangeEqual(int A){
        int temp= A;
        int msb =0;
        while(temp>0){
           msb++;
           temp=temp>>1;
        }
       int i=0;
        while(i < msb){
           A= checkBit(A,i) ? unSetBit(A,i) : setBit(A,i);
           i++;
        }
        A=setBit(A,msb);
      return A;
    }

    private int setBit(int A,int B){
        return  A | (1 << B);
    }

    private int unSetBit(int A,int B){
        return checkBit(A,B) ? A ^ 1<<B : A;
    }

    private boolean checkBit(int A,int i){
        return (A & (1 << i)) == 1 << i;
    }

}
