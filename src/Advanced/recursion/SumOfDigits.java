package Advanced.recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int A=83557;
        while(A>9){
            System.out.println(A);
            A=sumOfDigit(A);
        }
        System.out.println("===============================");
        System.out.println(A);

    }
    public static int sumOfDigit(int A){
        if(A == 0){
            return 0;
        }
        int sum = 0;
        sum += A%10+sumOfDigit(A/10);
        return sum;
    }

}
