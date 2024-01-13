package Advanced.maths.permutations;

public class NCR {
    public static void main(String[] args) {
        NCR ncr= new NCR();
        System.out.println(ncr.solve(5,2,13));

    }
    public int solve(int A, int B, int C) {
        int[][] temp=new int[A+1][B+1];
        for(int i=0;i<=A;i++){
            for(int j=0;j<=B;j++){
                if(i<j){
                    temp[i][j]=0;
                }else if(j==0){
                    temp[i][j]=1;
                }else{
                    temp[i][j]= (temp[i-1][j]  + temp[i-1][j-1]) % C ;
                }

            }
        }

        return temp[A][B];
    }


    public static int ans(int a,int b,int c){

        int temp= Math.min(b,(a-b));
        long upper = findNCRDi(a,temp);
        System.out.println(upper);
        double lower = factorial(temp);
        System.out.println(lower);
        double ncr = (upper / lower);
        int mod = (int) (Math.pow(10,9)+7);
        double ans = (ncr % c);
        double result = (ncr % c + c) % c;
        return (int) (result % mod);
    }

    public  static long findNCRDi(int n,int r){
        long ans = 1;
        int mod = (int) (Math.pow(10,9)+7);
        while(r>=1){
            ans = ans * n;
          //  ans = ans % mod;
            n = n-1;
            r = r-1;
        }

        return ans;
    }

    public static double factorial(int n){
        if(n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
