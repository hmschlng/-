package Chapter13;

import java.util.*;

public class Virus_1317 implements Comparable<Virus_1317> {
	int x, y, num;	// (x,y) -> 바이러스의 위치 , num -> 바이러스의 번호
	public Virus_1317(int x, int y, int num) {
		this.x = x;
		this.y = y;	
		this.num = num;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getNum() {
		return num;
	}
	
	public int compareTo(Virus_1317 vir) {
		return this.num - vir.num;
	}
	
	public String toString() {
		return "(" + x + " " + y + ")" + " " + num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();	// 바이러스의 위치, 번호표가 있는 줄의 개수 n개
		int k = scan.nextInt();	// 바이러스의 최대 번호
		// 바이러스의 시작 좌표 & 번호
			
//		int[][] arrVirus = {
//				{1,0,2},
//				{0,0,0},
//				{3,0,0}
//		};
		int[][] arrVirus = new int[n][n];
		for(int i=0 ; i<n ; i++)
			for(int j=0 ; j<n ; j++)
				arrVirus[i][j] = scan.nextInt(); 
		// s초 뒤에 (x,y)에 존재하는 바이러스의 종류를 구하기
		int s = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		// 우, 하, 좌, 상
		int[] dx = {0, 1,  0, -1};
		int[] dy = {1, 0, -1,  0};
		
		ArrayList<Virus_1317> arr = new ArrayList<>();
		
		for(int i=0 ; i<arrVirus.length ; i++)
			for(int j=0 ; j<arrVirus[0].length ; j++) {
				if(arrVirus[i][j] != 0)
					arr.add(new Virus_1317(i, j, arrVirus[i][j]));
			}
		// 위에서 정의한 compareTo의 기준으로, num(바이러스의 번호)을 기준으로 오름차순으로 정렬
		arr.sort(null);
//		for(Virus virus : arr)
//			System.out.println(virus);
//		System.out.println();
		//s번 진행
		while(s != 0) {
		int nx,ny, nnum;
		int arrlen = arr.size();
		for(int i=0 ; i<arrlen ; i++) {
			nnum = arr.get(i).getNum();
			for(int j=0 ; j<4 ; j++) {
				nx = (arr.get(i)).getX() + dx[j];
				ny = (arr.get(i)).getY() + dy[j];
				if(0<=nx && nx<n && 0<=ny && ny<n && arrVirus[nx][ny] == 0) {
					arr.add(new Virus_1317(nx, ny, nnum));
					arrVirus[nx][ny] = nnum; 
				}
			}
		}
		arr.sort(null);
		s--;
		}
		
//		for(Virus virus : arr)
//			System.out.println(virus);
		System.out.println(arrVirus[x-1][y-1]);
		scan.close();
	}

}

//3 3
//1 0 2
//0 0 0
//3 0 0
//2 3 2

//3 3
//1 0 2
//0 0 0
//3 0 0
//1 2 2