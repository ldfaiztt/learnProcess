package algorithm.DP;

/**
 *题目：
 *平面上有N*M个格子，每个格子中放着一定数量的苹果。
 *你从左上角的格子开始， 每一步只能向下走或是向右走，每次走到一个格子上就把格子里的苹果收集起来， 这样下去，你最多能收集到多少个苹果。
 *
 *A[i][j]表示第[i,j]个格子中的苹果数
 *S[i][j]表示到达第[i,j]个格子能收集到的最多的苹果数
 *
 *S[i][j]=A[i][j]+max{A[i-1][j] if i>0;A[i][j-1] if j>0};
 */
public class maxAppleCount {
	public static void main(String[] args) {
		int[][] A = new int[][]{
				{0,9,9,9,9,9,9,9,9,9},
				{9,9,9,9,9,9,9,9,9,9},
				{9,9,9,9,9,9,9,9,9,9},
				{9,9,9,9,9,9,9,9,9,9},
				{9,9,9,9,9,9,9,9,9,9},
				{9,9,9,9,9,9,9,9,9,9},
				{9,9,9,9,9,9,9,9,9,9},
				{9,9,9,9,9,9,9,9,9,9},
				{9,9,9,9,9,9,9,9,9,9},
				{9,9,9,9,9,9,9,9,9,9},};
				
		int m = A.length;
		int n = A[0].length;
		int[][] S = new int[m][n];
		for(int c=0;c<3;c++){
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					int a=0,b=0;
					if(i>0){
						a=S[i-1][j];
					}
					if(j>0){
						b=S[i][j-1];
					}
					S[i][j]+=A[i][j]+(a>b?a:b);
					A[i][j]=0;
				}
			}
		}
		System.out.println(S[m-1][n-1]);
	}
	
}
