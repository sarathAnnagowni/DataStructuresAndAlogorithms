import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AdvancedJava {
   /* public static void main(String[] args) {
       // (1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6)
        *//*
        (47, 76), (51, 99), (28, 78), (54, 94), (12, 72), (31, 72),
         (12, 55), (24, 40), (59, 79), (41, 100), (46, 99), (5, 27),
          (13, 23), (9, 69), (39, 75), (51, 53), (81, 98), (14, 14),
          (27, 89), (73, 78), (28, 35), (19, 30), (39, 87), (60, 94),
          (71, 90), (9, 44), (56, 79), (58, 70), (25, 76), (18, 46), (14, 96),
           (43, 95), (70, 77), (13, 59), (52, 91), (47, 56), (63, 67), (28, 39),
           (51, 92), (30, 66), (4, 4), (29, 92), (58, 90), (6, 20), (31, 93),
           (52, 75), (41, 41), (64, 89), (64, 66), (24, 90), (25, 46),
           (39, 49), (15, 99), (50, 99), (9, 34), (58, 96), (85, 86),
           (13, 68), (45, 57), (55, 56), (60, 74), (89, 98), (23, 79), (16, 59),
           (56, 57), (54, 85), (16, 29), (72, 86), (10, 45), (6, 25), (19, 55),
           (21, 21), (17, 83), (49, 86), (67, 84), (8, 48), (63, 85), (5, 31), (43, 48),
           (57, 62), (22, 68), (48, 92), (36, 77), (27, 63), (39, 83), (38, 54),
           (31, 69), (36, 65), (52, 68)
         *//*
        ArrayList<Interval> list=new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(6,9));

        new Interval(2,6);

        AdvancedJava sd=new AdvancedJava();
        ArrayList<Interval> list2 =sd.insert(list,new Interval(2,6));
        for (Interval i1 : list2) {
            System.out.println(i1.start+" "+i1.end);
        }





    }*/

    public static void main(String[] args) {
        String s="101";
        int[] ans=flipMine(s);
        for (int a:ans) {
          System.out.println(a);
        }

    }
    public static int[] flip(String A) {
        int oneCount = 0, maxCount = 0, currentLeft = 0, left = -1, right = -1;

        for(int i=0; i< A.length(); i++){
            oneCount = (A.charAt(i) == '0') ? oneCount + 1 : oneCount - 1;

            if(oneCount > maxCount)
            { // if one count is greater than prev then we will update the start, end pos
                maxCount = oneCount;
                left = currentLeft;
                right = i;
            }
            if(oneCount < 0)
            {
                // if its less then 0, than start looking for a new posibility from the next index
                oneCount = 0;
                currentLeft = i +1;
            }
        }
        if(left != -1 || right != -1)
            return new int[]{left+1, right+1};
        return new int[0];
    }
    public static int[] flipMine(String A) {
        char[] charArray=A.toCharArray();
        int[] zeroCharArray=new int[charArray.length];
        int[] oneCharArray=new int[charArray.length];
        int zeroCount=0;
        int oneCount=0;
        if (charArray[0] == '0') {
            zeroCount++;
            zeroCharArray[0]=zeroCount;
        }else{
            oneCount++;
            oneCharArray[0]=oneCount;
        }
        for(int i=1;i<charArray.length;i++){
            if(charArray[i]=='0'){
                zeroCount++;
                zeroCharArray[i]=zeroCount;
                oneCharArray[i]=oneCharArray[i-1];
            }else{
                oneCount++;
                oneCharArray[i]=oneCount;
                zeroCharArray[i]=zeroCharArray[i-1];
            }
        }
        int R=0;
        int L=0;
        int maxDiff=Integer.MIN_VALUE;
        int minDiff=charArray.length;
        for(int j=oneCharArray.length-1;j>=0;j--){
            int diff=zeroCharArray[j]-oneCharArray[j];
            if(diff > maxDiff){
                maxDiff= diff;
                R=j;
            }
            if( diff< minDiff){
                minDiff=diff;
                L=j;
            }
        }
        if(L>R ){
            return new int[0];
        }
        int[] arr={L+1,R+1};
        return arr;
    }

    public static int maximumOnes(int[][] A) {
        int n=A.length;
        int ans=n-1;
        int row=0;
        int i=0;
        int j=n-1;
        while( i<n && j>=0 ){
            if(A[i][j]==1){
                if(j==0){
                    return i;
                }
                j--;
            }else{
                ans=Math.min(j,ans);
                i++;
                j=n-1;
            }
        }
        return row;


    }

    public static int[] plusOne(int[] A) {
        int[] ans=new int[A.length+1];
        int carry=0;
        for(int i=A.length-1;i>=0;i--){

            int n=A[i];
            if(i==A.length-1){
                n=n+1;
            }
            int an=n+carry;
            int r=an%10;
            carry=an/10;

            ans[i+1]=r;
            if(carry==1 && i==0){
                ans[0]=carry;
            }
        }
        if(ans[0]==1)
            return ans;
        else{
            int i=0;
            while(ans[i]==0){
              i++;
            }
            int[] ans1=new int[ans.length-i];
            System.arraycopy(ans, i, ans1, 0, ans1.length);
            return ans1;
        }

    }

    public static int[][] generateMatrix(int A) {
        int[][] ans=new int[A][A];
        int c=0;
        int n=A;
        int row=0;
        int col=0;
        while(n>1){
            int i=row;
            int j=col;
            for(int k=1;k<=n-1;k++){
                c++;
                ans[i][j]=c;
                j++;
            }
            for(int k=1;k<=n-1;k++){
                c++;
                ans[i][j]=c;
                i++;
            }
            for(int k=1;k<=n-1;k++){
                c++;
                ans[i][j]=c;
                j--;
            }
            for(int k=1;k<=n-1;k++){
                c++;
                ans[i][j]=c;
                i--;
            }
            row++;
            col++;
            n=n-2;
        }
        if(n==1){
            ans[row][col]=c+1;
        }

      return ans;

    }
    public static int sortedRowMatrix(int[][] A, int B) {
        int row=0;
        int col=A[0].length-1;
        int ans=Integer.MAX_VALUE;
        while(row < A.length && col >=0){
            if(B > A[row][col]){
                row++;
            }else if(B < A[row][col]){
                col--;
            }else{
                int a=(row+1)*1009+col+1;
                ans=Math.min(a,ans);
                if(B==A[row][col-1]){
                    col--;
                }else{
                    row++;
                }


            }

        }
        if(ans < Integer.MAX_VALUE){
            return ans;
        }


        return -1;

    }
    public static int[] solve(int A, int[][] B) {
            int[] ans=new int[A];
            for(int i=0;i<B.length;i++){
                int start=B[i][0]-1;
                int end=B[i][1];
                int value=B[i][2];
                if( start >= 0){
                    ans[start]+=value;
                }
                if(end < A){
                    ans[end]-=value;
                }
            }

            for(int i=1;i<ans.length;i++){
                ans[i]+=ans[i-1];
            }
            return ans;
    }
    public ArrayList<Interval> mergeOverlappingIntervals(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans=new ArrayList<>();
        Collections.sort(intervals,new IntStartComparator());
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start <= end){
                start=Math.min(start,intervals.get(i).start);
                end=Math.max(end,intervals.get(i).end);
            }else{
                Interval in=new Interval(start,end);
                start=intervals.get(i).start;
                end=intervals.get(i).end;
                ans.add(in);
            }
        }
        Interval in=new Interval(start,end);
        ans.add(in);
        return ans;
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans=new ArrayList();
        int newIntervalStart=newInterval.start;
        int newIntervalEnd=newInterval.end;
        for(int i=0;i<intervals.size();i++){
            if(intervals.get(i).end < newInterval.start ){
                ans.add(intervals.get(i));
            }else if(intervals.get(i).start > newInterval.end){
                ans.add(new Interval(newIntervalStart,newIntervalEnd));
                for(int j=i;j<intervals.size();j++){
                    ans.add(intervals.get(j));
                }
                return ans;
            }
            else{
                newIntervalStart=Math.min(intervals.get(i).start,newIntervalStart);
                newIntervalEnd=Math.max(intervals.get(i).end,newIntervalEnd);
            }
        }
        ans.add(new Interval(newIntervalStart,newIntervalEnd));
        return ans;
    }
}

class Interval {
    int start;
    int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
class IntStartComparator implements Comparator<Interval>{

    @Override
    public int compare(Interval o1, Interval o2) {
        Integer i1=o1.start;
        Integer i2=o2.start;
        return i1.compareTo(i2) ;
    }
}