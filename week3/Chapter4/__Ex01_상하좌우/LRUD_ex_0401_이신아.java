package Chapter4;

import java.util.Scanner;

// 		while(scan.hasNext()) 또 여기서 실행하면 enter때문에 무한루프걸리는데, 어떻게 해야하지?
public class LRUD_ex_0401 {

//	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
//		int[] arr = {1,1};
//		char word;
//		
//		while(scan.hasNext()) {
//			word = scan.next().charAt(0);
//			switch (word) {
//			case 'L': {
//				if(arr[1] == 1)
//					break;
//				arr[1] -= 1;
//				break;
//			}
//			case 'R': {
//				if(arr[1] == n)
//					break;
//				arr[1] += 1;
//				break;
//			}
//			case 'U': {
//				if(arr[0] == 1)
//					break;
//				arr[0] -= 1;
//				break;
//			}
//			case 'D': {
//				if(arr[0] == n)
//					break;
//				arr[0] += 1;
//				break;
//			}
//			}
//		}
//		scan.close();
//		System.out.println(arr[0] + " " + arr[1]);
	
		// 5
		// R R R U D D
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// N을 입력받기
		int n = scan.nextInt();
		scan.nextLine();	//버퍼 비우기
		int y = 1;
		int x = 1;
		int nx = 0, ny = 0;
		
		 // L, R, U, D에 따른 이동 방향
		char[] wordarr = {'L', 'R', 'U', 'D'};
		int[] dy = {0,0,-1,1};
		int[] dx = {-1,1,0,0};
		
		String str = scan.nextLine();
		String[] strarr = str.split(" ");
		char word;
		// 이동 하나씩 확인
		for(String s : strarr) {
			word = s.charAt(0);
			for(int i=0 ; i<wordarr.length ; i++) {
				if(word == wordarr[i]) {
					ny = y + dy[i];
					nx = x + dx[i];
				}
			}
			// 범위 벗어나는지 체크 후, 벗어나면 무시
			if(nx<1 || ny<1 || ny>n || nx >n)
				continue;
			// 대입하기
			x = nx;	
			y = ny;	
		}
		scan.close();
		System.out.println(y + " " + x);
		
	}

}
