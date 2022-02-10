package Chapter12;

import java.util.Arrays;
import java.util.Scanner;

public class ReSort_1208 {

	public static void resort(String str) {
		int strlen = str.length();
		int num = 0;
		int totalnum = 0;
		// char 배열은 '\0'으로 초기화 됨
		char[] carr = new char[strlen];
		
		for(int i=0 ; i<strlen ; i++) {
			String s = str.substring(i, i+1);
			char c = s.charAt(0);		// i번째 문자 or 숫자를 문자형태로 저장
//			num = Integer.parseInt(s);	// k를 숫자로 변환할때 오류
			// 숫자일때 -> 문자형태로 저장된 숫자를 다시 숫자로 변환
			if(c < 'A') {
				num = c - '1' + 1;
				totalnum += num;
			}
			// 문자일때
			else 
				carr[i] = c;
		}
		// carr배열이 다 채워지지 않은 채로 정렬을 하면, ' ' 공백으로 채워지게 되고, 
		Arrays.sort(carr);
		for(char c : carr) {
			if(c != '\0')
				System.out.print(c);
		}
		System.out.println(totalnum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		resort(str);
		sc.close();
	}

}

// K1KA5CB7
// AJKDLSI412K4JSJ9D