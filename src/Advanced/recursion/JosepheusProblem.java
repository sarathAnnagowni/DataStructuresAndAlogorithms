package Advanced.recursion;

public class JosepheusProblem {
    public static void main(String[] args) {
        int[] p = {1,2,3,4,5,6,7};
        int saved = josephesProblem(5,4);
        System.out.println(saved);
    }
    public static int josephesProblem(int n,int k){
        if(n == 1){
            return 0;
        }
        return (josephesProblem(n-1,k)+k) % n ;
    }
}
