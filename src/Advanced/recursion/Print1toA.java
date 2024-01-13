package Advanced.recursion;

public class Print1toA {
    public static void main(String[] args) {
        printAto1(7);
    }

    public static void printAto1(int A){
        if(A==0){
            return;
        }
        System.out.print(A+" ");
        printAto1(A-1);
    }
    public static void printA(int A){
        if(A==0){
            return;
        }
        printA(A-1);
        System.out.print(A+" ");
        System.out.println("");
        return;
    }
    public static void printAll(int A,int N){
        if(A>N){
            System.out.println("");
            return;
        }
        System.out.print(A+" ");
        printAll(A+1,N);
        return;
    }
}
