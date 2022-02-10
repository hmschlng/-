package Chapter13;

import java.util.Scanner;

public class FindCity_1315 {

	public static int INF = 987654321;
	// x부터 y까지의 최단거리 저장
	public static int[][] distance = new int[5][5];
	// 시작점 x -> 매개변수로 전달해도 상관없지만, 매개변수의 양이 또 늘어나기 때문에, 전역변수로 빼서 사용
	public static int x;
	
	// 처음 제공된 시작점에 대해서만 최소거리 탐색 가능
	// 시작점 : x , 이동 할 위치 : y
	// count로 하나씩 이동할때마다 +1로 이동하고, 끝에 도달하면 최단거리를 distance에 저장해 놓는다
	public static void findMin(int[][] arr, int y, int count) {
		for(int i = 0 ; i < arr[y].length ; i++) {
			if(arr[y][i] == 1)
				findMin(arr, i, count+1);
		}
		// 출발 도시는 고정이고 출발 도시에 대해서만 최단거리를 구하기 때문에 
		// 시작점을 전역변수로 고정해놓고 많은 경로 중에서 최단경로만 저장하는 부분
		if(distance[x][y] > count)
			distance[x][y] = count; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();	// 도시의 개수 4
		int m = scan.nextInt();	// 도로의 개수 4
		int k = scan.nextInt();	// 최단 거리 2인 것 출력
		x = scan.nextInt();	// 시작점 1
//		int[][] arr = {
//				{},
//				{2,3},
//				{3,4},
//				{},
//				{}
//		};
		// int[a][b] = 1 이면, a에서 b로 길이 연결 되어 있다는 것을 의미한다
		int[][] arr = new int[n+1][n+1];
		for(int i = 0 ; i < m ; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			arr[a][b] = 1;
		}
		
		// 거리들 큰 수로 초기화
		for(int i=0 ; i<5; i++)
			for(int j=0 ; j<5 ; j++)
				distance[i][j] = INF;
		
		findMin(arr, x, 0);
		
		int zeroCount = 0;
		// 최단 거리가 같은 것만 출력
		for(int i = 0 ; i < distance[x].length ; i++) {
			if(distance[x][i] == k)
				System.out.println(i);
			else 
				zeroCount++;
		}
		if(zeroCount == distance[x].length)
			System.out.println(-1);
		scan.close();
	}

}

// 정답 : 4
//4 4 2 1
//1 2
//1 3
//2 3
//2 4

//정답 : -1
//4 3 2 1
//1 2
//1 3
//1 4

//정답 : 2 3
//4 4 1 1
//1 2
//1 3
//2 3
//2 4