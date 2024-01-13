package Advanced.maths.modulus;

public class DeleteOne {

    public static void main(String[] args) {

       int[] A = {5, 15, 30};
        for(int a : leftGcdArray(A)){
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println(deleteOne(A));
       for(int a : rightGcdArray(A)){
           System.out.print(a + " ");
       }

    }

    public static int deleteOne(int[] A){
        int[] leftGCD = leftGcdArray(A);
        int[] rightGCD = rightGcdArray(A);
        int maxGCD=1;
        for(int i=0;i<A.length;i++){
            int tempGCD=0;
            if(i==0){
                tempGCD = rightGCD[1];
            }else if(i== A.length-1){
                tempGCD = leftGCD[i-1];
            }else{
                tempGCD = gcd(leftGCD[i-1],rightGCD[i+1]);
            }
            maxGCD = Math.max(maxGCD,tempGCD);
        }
        return maxGCD;
    }
    public static int[] leftGcdArray(int[] A){
        int[] gcdArray = new int[A.length];
        gcdArray[0] = A[0];
        int i=1;
        while(i<A.length){
            gcdArray[i]= gcd(gcdArray[i-1],A[i]);
            i++;
        }
        return gcdArray;
    }

    public static int[] rightGcdArray(int[] A){
        int[] gcdArray = new int[A.length];
        gcdArray[A.length-1] = A[A.length-1];
        int i=A.length-2;
        while(i>=0){
            gcdArray[i]= gcd(A[i],gcdArray[i+1]);
            i--;
        }
        return gcdArray;
    }
    public static int gcd(int A,int B){
        if(B == 0){
            return A;
        }else{
            return gcd(B,A%B);
        }
    }
}
