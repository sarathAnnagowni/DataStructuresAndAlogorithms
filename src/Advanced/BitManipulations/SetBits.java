package Advanced.BitManipulations;

public class SetBits {
    public static void main(String[] args) {
        System.out.println(getSetBits(9));
    }
    public static int getSetBits(int n){
        int ans = 0;
        while(n > 0){
            if ((n & 1) ==1){
                ans++;
            }
            n=n>>1;
        }
        return ans;
    }

}
