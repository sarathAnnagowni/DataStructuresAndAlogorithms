package Advanced.maths.permutations;
/*
Write a program to print the pascal triangle up to A rows.



Problem Constraints

1 <= A <= 25



Input Format

The first argument is an integer A.



Output Format

Return a 2D array consisting of A rows whose each row contains A integers.



Example Input

Input 1:

A = 3
Input 2:

A = 5


Example Output

Output 1:

1 0 0
1 1 0
1 2 1
Output 2:

1 0 0 0 0
1 1 0 0 0
1 2 1 0 0
1 3 3 1 0
1 4 6 4 1
 */
public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle pt=new PascalTriangle();
        int[][] ans=pt.solve(5);
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
              System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] solve(int A) {
        int[][] ans= new int[A][A];
        for(int i=0;i<A;i++){
            ans[i][i]=1;
            ans[i][0]=1;
        }
        for(int i=1;i<A;i++){
            for(int j=1;j<A;j++){
                ans[i][j] = ans[i-1][j]+ ans[i-1][j-1];
            }
        }
        return ans;
    }
}
