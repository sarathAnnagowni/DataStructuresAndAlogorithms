public class Digitone {
    public static void main(String[] args) {
        System.out.println(getOneDigitUptoN(10000));
    }
    public static int getOneDigitUptoN(int n){
        int ans = 1;
        for(int i=2;i <=n;i++){
            ans +=getOneDigit(i);
        }
        return ans;
    }
    public static int getOneDigit(int n){
        int ans = 0;
        while(n > 0){
            int rem = n % 10;
            if(rem == 1){
                ans++;
            }
            n = n/10;
        }
        return ans;
    }
}
