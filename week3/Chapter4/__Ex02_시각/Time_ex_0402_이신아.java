package Chapter4;

import java.util.Scanner;

public class Time_ex_0402 {

	public static int countThree(int n) {
		int[] time = new int[2];
		int[] minute = new int[2];
		int[] second = new int[2];
		
		int count = 0;
		// 00:00:00 ~ n(<=23):59:59 모든 시간 탐색 후 3이 들어간 숫자 찾기
		for(int i=0 ; i<=n ; i++) {
			time[0] = i / 10;
			time[1] = i % 10;
			for(int j=0 ; j<60 ; j++) {
				minute[0] = j / 10;
				minute[1] = j % 10;
				for(int k=0 ; k<60 ; k++) {
					second[0] = k / 10;
					second[1] = k % 10;
					if(time[1]==3 || minute[0]==3 || minute[1]==3 || second[0]==3 || second[1]==3)
						count++;
				}
	
			}
			
		}
		return count;
	}
	
	// 위와 달리, 한 배열에 다 합쳐놓을 수도 있지만, 가독성을 위해서 따로 선언하는게 좋을 것 같음
//	public static int countThree2(int n) {
//		int[] alltime = new int[6];
//		
//		int count = 0;
//		// 00:00:00 ~ n(<=23):59:59 모든 시간 탐색 후 3이 들어간 숫자 찾기
//		for(int i=0 ; i<=n ; i++) {
//			alltime[0] = i / 10;
//			alltime[1] = i % 10;
//			for(int j=0 ; j<60 ; j++) {
//				alltime[2] = i / 10;
//				alltime[3] = i % 10;
//				for(int k=0 ; k<60 ; k++) {
//					alltime[4] = i / 10;
//					alltime[5] = i % 10;
//					
//				}
//	
//			}
//			
//		}
//		
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(countThree(n));
		sc.close();
	}

}
