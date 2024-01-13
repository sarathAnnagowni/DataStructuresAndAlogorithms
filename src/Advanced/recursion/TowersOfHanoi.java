package Advanced.recursion;

public class TowersOfHanoi {
    public static void main(String[] args) {
        int input =3;
        int noOfMoves = (int) Math.pow(2,input)-1;
        int[][] ans = new int[noOfMoves][3];
        towersOfHanoi(input,1,2,3,input,ans,0);
        for (int[] row:ans) {
            for(int ele : row){
                System.out.print(ele+" ");
            }
            System.out.println();

        }
    }
    public static int towersOfHanoi(int n, int source, int temp, int dest,int disk,int[][] ans,int counter){
        if(n==1){
            int[] result={disk,source,dest};
            ans[counter]=result;
            counter++;
            return counter;
        }
        counter= towersOfHanoi(n-1,source,dest,temp,n-1,ans,counter);
        counter=towersOfHanoi(1,source,temp,dest,n,ans,counter);
        counter=towersOfHanoi(n-1,temp,source,dest,n-1,ans,counter);
        return counter;
    }


}
