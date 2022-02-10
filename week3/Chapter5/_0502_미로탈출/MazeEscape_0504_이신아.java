package Chapter5;

import java.util.Scanner;

public class MazeEscape_0504 {

	public static boolean[][] visited = new boolean[200][200];

	public static void countMove(int[][] arr, int x, int y, int count) {
		visited[x][y] = true; 
		if(x == arr.length-1 && y == arr[0].length-1)
			System.out.println(count);
		// 우, 하, 좌, 상
		int[] dx = {0, 1,  0, -1};
		int[] dy = {1, 0, -1,  0};
		int nx, ny;
//		int count = 1;
		for(int i = 0 ; i < 4 ; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			// 방문처리를 안하면, 왔던 길을 다시 갈 수 있으므로 방문처리 해줘야함
			if(0<=nx && nx<arr.length && 0<=ny && ny<arr[0].length && visited[nx][ny] == false && arr[nx][ny] == 1)
				countMove(arr, nx, ny, count+1);
		}
//		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine(); // 버퍼 지우기
        
        int[][] arr = new int[n][m];
        visited = new boolean[n][m];
		
        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = scan.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        
		countMove(arr, 0, 0, 1);
		scan.close();
	}

}

//두 개다 정답 = 10

//5 6
//101010
//111111
//000001
//111111
//111111

//5 6
//101010
//111111
//001000
//111111
//111111