public class Strings {
    public static void main(String[] args) {
        Strings s=new Strings();
        String[] str={"aaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        System.out.println(s.longestCommonPrefix(str));
    }
    private String concat(String A){
        return A+A;
    }
    public int solve(char[] A) {
        for(char c : A){
            if(!isAlpha(c)){
                return 0;
            }
        }
        return 1;
    }
    private boolean isAlpha(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
    public String longestCommonPrefix(String[] A) {
        if(A.length ==1){
            return A[0];
        }
        int minIndex=0;
        for(int i=1;i<A.length;i++){
            if(A[i].length() < A[minIndex].length()){
                minIndex=i;
            }
        }

        int i=0,k=0,j=0;
        int n=A[minIndex].length();
        while(j<n){
            for(String a:A){
                if(a.charAt(i)==A[minIndex].charAt(i)){
                   k=i;
                }else{
                    j=n;
                    k=i-1;
                    break;
                }
            }
            //k=i;
            i++;
            j++;
        }
        return A[minIndex].substring(0,k+1);

    }
    private String replaceVowelsWithPound(String A){
        char[] arr=A.toCharArray();
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]=='a' || arr[j]=='e' || arr[j]=='i' || arr[j]=='o' || arr[j]=='u'){
                arr[j]='#';
            }
        }
        return new String(arr);
    }
    private String deleteUpperCaseLetters(String A){
        char[] arr=A.toCharArray();
        char[] newChar=new char[arr.length];
        int i=0;
        int j=0;
        while(i<arr.length){
            if(!(arr[i] >= 'A' && arr[i] <='Z')){
                newChar[j]=arr[i];
                j++;
            }
            i++;
        }
         j=arr.length-1;
        while(newChar[j]==0){
            j--;
        }
        return new String(newChar,0,j+1);
    }
    public String longestPalindrome(String A) {
        char[] str=A.toCharArray();
        int n=str.length;
        //for odd length polindrome
        String oddPoindrome="";
        String evenPoindrome="";
        int oddPoindromeLength=0;
        int evenPoilndromeLength=0;
        for(int i=0;i<n;i++){
            int p1=i,p2=i;
            while((p1>=0 && p2<n) && (str[p1]==str[p2])){
                p1--;
                p2++;
            }
            int length =p2-p1-1;
            if(length > oddPoindromeLength){
                oddPoindrome=A.substring(p1+1,p2);
            }
            oddPoindromeLength=Math.max(length,oddPoindromeLength);

        }
        //
        for(int i=0;i<n;i++){
            int p1=i,p2=i+1;
            while((p1>=0 && p2<n) && (str[p1]==str[p2])){
                p1--;
                p2++;
            }
            int length =p2-p1;
            if(length > evenPoilndromeLength){
                evenPoindrome=A.substring(p1+1,p2);
            }
            evenPoilndromeLength=Math.max(evenPoilndromeLength,length);
        }
        if(evenPoilndromeLength > oddPoindromeLength) {
            return evenPoindrome;
        }else{
            return oddPoindrome;
        }
    }
    public String reverseWordUsingCharArray(String A){
        char[] str=A.toCharArray();
        int n=str.length;
        reverse(str,0,n);
        int start=0,end=0;
        int i=0;
        while(i<n){
            if(str[i]==' '){
                end=i;
                reverse(str,start,end);
                start=end+1;
            }
            i++;
        }
        reverse(str,start,n);
        start=0;
        while(str[start]==' '){
            start++;
        }
        end=n-1;
        while(str[end]==' '){
            end--;
        }
        return new String(str).substring(start,end+1);
    }
    public int subStringCount(String A) {
        int count=0;
        int n=A.length();
        if(n<3){
            return 0;
        }

        for(int i=0;i<n-2;i++){
           String subString= A.substring(i,i+3);
            if("bob".equals(subString)){
                count++;
            }
        }
        return count;
    }
    public String reverseWord(String A) {
        String reverseString =reverse(A);
        String[] arr=reverseString.split(" ");
        String ans="";
        for(String a : arr){
            ans+=reverse(a)+" ";
        }
        return ans.substring(1,ans.length()-1);
    }


    public String reverse(String A) {
        char[] str=A.toCharArray();
        for(int i=0,j=str.length-1;i<j;i++,j--){
            char temp=str[i];
            str[i]=str[j];
            str[j]=temp;
        }
        return new String(str);
    }
    public void reverse(char[] A,int start,int end) {
        for(int i=start,j=end-1;i<j;i++,j--){
            char temp=A[i];
            A[i]=A[j];
            A[j]=temp;
        }
    }

    public String toggle(String A) {
        char[] str=A.toCharArray();
        int toUpperCase='A'-'a';
        int toLowerCase='a'-'A';
        for(int i=0;i<str.length;i++){
            if(str[i]>='A' && str[i]<='Z'){
                str[i]=(char)(str[i]+toLowerCase);
            }
            else if(str[i]>='a' && str[i]<='z'){
                str[i]=(char)(str[i]+toUpperCase);
            }
        }
        return new String(str);

    }
}
