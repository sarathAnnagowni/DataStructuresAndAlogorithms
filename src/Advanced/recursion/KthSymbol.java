package Advanced.recursion;
/*
N = 5 and k = 2   ans 3
N = 5 and k = 3   ans 4



 */
public class KthSymbol {
    public static void main(String[] args) {
      System.out.println(kthSymbol(2));
    }

    public static int solve(int A, long B) {

        return kthSymbol(A).toCharArray()[(int) B];
    }

    public static String kthSymbol(int A){
        if(A==1)
            return "0";
        return kthSymbol(A-1)+flip(kthSymbol(A-1));
    }

    public static String flip(String A){
        char[] res=A.toCharArray();
        for(int i=0;i<res.length;i++){
            if(res[i]=='1'){
                res[i]='0';
            }else{
                res[i]='1';
            }
        }
        return new String(res);
    }
}
