package Advanced.BitManipulations;

public class FindIsPowerOf2 {
    public static void main(String[] args) {
        int n =48;
        System.out.println(new FindIsPowerOf2().isPowerOf2(0));

    }
    boolean isPowerOf2(int n){
        return BitManipulations.noOfSetBitsWithKerninghanAlog(n) == 1;

    }
}
