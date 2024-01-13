package Advanced.recursion;

public class StringPolindrome {
    public static void main(String[] args) {
        System.out.println(isPolindrome(0,"aba",2));
    }
    public static boolean isPolindrome(int start,String str,int end){
        if(start >= end){
            return true;
        }else{
           if(str.charAt(end)==str.charAt(start)){
                return isPolindrome(start+1,str,end-1);
            }else{
               return false;
           }
        }
    }
}
