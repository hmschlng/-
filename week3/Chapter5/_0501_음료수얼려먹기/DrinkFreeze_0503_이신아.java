package Chapter5;

import java.util.Scanner;

public class DrinkFreeze_0503 {

	public static boolean[][] visited = new boolean[1000][1000];
	
	public static int checkIce(int[][] arr, int x, int y) {
		visited[x][y] = true;
		// 상, 좌, 하, 우
		int[] dx = {-1,  0, 1, 0};
		int[] dy = { 0, -1, 0, 1};
		int nx, ny;
		for(int i = 0 ; i < 4 ; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			// 얼음 틀의 공간을 벗어나지 않는 선에서, 방문하지 않고, 0(구멍이 뚫려 있는 부분)이면 4방향을 재귀호출로 모두 검토해서 
			// 4방향을 모두 방문하거나, 1이 될때까지 재귀호출을 통해 반복 한 뒤, 그 것을 한 구역으로 정해서 1을 return하기
			if(0<=nx && nx<arr.length && 0<=ny && ny<arr[0].length && visited[nx][ny] == false && arr[nx][ny] == 0) {
				visited[nx][ny] = true; 
				checkIce(arr, nx, ny);
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		visited = new boolean[n][m];
		int count = 0;
		int[][] arr = new int[n][m];
		// (x,y) 만큼 입력받기
		for(int i = 0 ; i < n ; i++)
			for(int j = 0 ; j < m ; j++) 
				arr[i][j] = scan.nextInt();
		
		for(int i = 0 ; i < n ; i++)
			for(int j = 0 ; j < m ; j++) {
				if( visited[i][j] == false && arr[i][j] == 0 )
					count += checkIce(arr, i , j);
			}
		System.out.println(count);
		scan.close();
	}

}

//4 5
//0 0 1 1 0
//0 0 0 1 1
//1 1 1 1 1
//0 0 0 0 0

//15 14
//0 0 0 0 0 1 1 1 1 0 0 0 0 0
//1 1 1 1 1 1 0 1 1 1 1 1 1 0
//1 1 0 1 1 1 0 1 1 0 1 1 1 0
//1 1 0 1 1 1 0 1 1 0 0 0 0 0
//1 1 0 1 1 1 1 1 1 1 1 1 1 1
//1 1 0 1 1 1 1 1 1 1 1 1 0 0
//1 1 0 0 0 0 0 0 0 1 1 1 1 1
//0 1 1 1 1 1 1 1 1 1 1 1 1 1
//0 0 0 0 0 0 0 0 0 1 1 1 1 1
//0 1 1 1 1 1 1 1 1 1 1 0 0 0
//0 0 0 1 1 1 1 1 1 1 1 0 0 0
//0 0 0 0 0 0 0 1 1 1 1 0 0 0
//1 1 1 1 1 1 1 1 1 1 0 0 1 1
//1 1 1 0 0 0 1 1 1 1 1 1 1 1
//1 1 1 0 0 0 1 1 1 1 1 1 1 1