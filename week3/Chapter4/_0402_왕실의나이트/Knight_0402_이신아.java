package Chapter4;

import java.util.*;

public class Knight_0402 {

		// word를 그냥 문자로 놓고 똑같이 상대좌표 구해도 아스키코드값으로 계산되므로, 굳이 숫자로 안바꿔줘도 된다.
	public static int cases(char word, int num) {
		int[] dx = {-2,-2, 2, 2, 1, -1, 1, -1};		// word의 상대좌표
		int[] dy = { 1,-1, 1,-1,-2, -2, 2, 2};		// num의 상대좌표
		int count = 0;
		
		for(int i=0 ; i<8 ; i++) {
			int nx = 0 , ny = 0;
			nx = word + dx[i];
			ny = num + dy[i];
			if('a'<=nx && nx<='h' && 1<=ny && ny<=8)
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		//a1이 들어오면 
		char word = s.charAt(0);					// word = a;
		int num = Integer.parseInt(s.substring(1));	// num =1;
		System.out.println(cases(word, num));
		scan.close();
	}

}

// 문자 a~h를 1~8로 바꾸는 법
// 'a' - 'a' + 1 = 1
// 'b' - 'a' + 1 = 2
// 'h' - 'a' + 1 = 8