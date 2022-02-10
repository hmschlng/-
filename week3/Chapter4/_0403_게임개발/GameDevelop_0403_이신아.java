package Chapter4;

import java.util.Scanner;

public class GameDevelop_0403 {

	public static int count = 0;	
	// 육지이면 0, 바다면 1로 표기
	public static int[][] isLand = new int[50][50];
	// 방문했으면 1, 안했으면 0
	public static int[][] cache = new int[50][50];
	// isLand, cache를 따로 사용하는 이유는, 밑의 답은 4여야하는데, isLand만 이용하여 방문한곳을 1로 바꾸면, 밑의 3개(ㄱ자)밖에 못감
//	입력(1)
//	4 4
//	1 1 0
//	1 1 1 1 
//	1 0 0 1 		=> 3
//	1 1 0 1
//	1 1 1 1

//	입력(2)
//	4 4
//	1 1 0
//	1 1 0 1 
//	1 0 0 1			=> 4
//	1 1 0 1
//	1 1 1 1
	// 재귀호출 시, 코드가 간단해짐
	public static void hasVisited(int x, int y, int direction) {
		//		북(0), 동(1), 남(2), 서(3)
		int[] dx = {-1, 0, 1, 0};
		int[] dy = { 0, 1, 0, -1};
		
		// 현재 위치 (x,y)를 처음 방문했을때, 표시
		if(isLand[x][y] == 0) {
			count++;
			cache[x][y] = 1; 	
		}
		
		// 현재 위치 (x,y)에서 바라보는 방향(direction)기준으로, 왼쪽부터 돌아서 동서남북을 다 방문했을때,
		// 이동한 위치가 0<=(nx,ny)<=3 && isLand[nx][ny]==0 (육지인 경우) && cache[nx][ny]==0 (한번도 방문 안한경우)
		// 위 3가지를 다 만족하면 그 위치로 이동
		for(int i = direction+3 ; i >= direction ; i--) {
			int nx = 0, ny = 0;
			// %연산은  dx, dy의 index가 0~3이므로 이 범위를 제한시켜주기 위해서 사용
			nx = x + dx[i % 4];		
			ny = y + dy[i % 4];
			if(0<=nx && nx<=3 && 0<=ny && ny<=3 && isLand[nx][ny] == 0 && cache[nx][ny] == 0)
				hasVisited(nx, ny, direction);
		}
		// for문에서 하나도 안걸리면 한칸 뒤로가기.
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int startx = sc.nextInt();
		int starty = sc.nextInt();
		int direction = sc.nextInt();
		isLand = new int[x][y];
		for(int i=0 ; i<x ; i++)
			for(int j=0 ; j<y ; j++)
				isLand[i][j] = sc.nextInt();
		hasVisited(startx, starty, direction);
		System.out.println(count);
		sc.close();
	}

}

//배열 둘다 -1로 초기화 시키는 방법??
		// 2차원 배열은 번거롭지만 이런 방식을 사용해야 함
//		int[][] arr = new int[2][2];
//		for(int i=0 ; i<2 ; i++)
//			Arrays.fill(arr[i], -1);
//		System.out.println(arr[1][1]);
//		int [] arr2 = new int[2];
//		Arrays.fill(arr2, 1);
//		for(int i : arr2)
//			System.out.println(i);