import java.util.Scanner;

public class App {
    public static void chase(int[][] ans, char[][] path, int i, int j, int row, int col){
		if(i<0 || i>=row || j<0 || j>= col || path[i][j]=='X'){
			return;
		}
		if(i==row-1 && j==col-1){
			ans[i][j]=1;
			return;
		}
		ans[i][j]=1;
		path[i][j]='X';
		chase(ans,path,i,j+1,row,col);
		chase(ans,path,i,j-1,row,col);
		chase(ans,path,i-1,j,row,col);
		chase(ans,path,i+1,j,row,col);

		ans[i][j]=0;
		path[i][j]='O';
	}
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();

		char[][] path = new char[row][col];

		for(int i=0;i<row;i++){
			path[i]=sc.next().toCharArray();
		}

		int[][] ans = new int[row][col];
		
		if(path[0][0]=='X'){
			System.out.println("NO PATH FOUND");
		}
		else{
			chase(ans,path,0,0,row,col);
			if(ans[row-1][col-1]==1){
				for(int[] arr : ans){
					for(int el : arr){
						System.out.print(el+" ");
					}
					System.out.println();
				}
			}
			else{
				System.out.println("NO PATH FOUND");
			}
		}
    }
}
