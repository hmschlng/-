package Chapter12;

import java.util.Scanner;

public class Compress_1209 {
	
	// Bottom-up 방식
	// str문자열을 num개의 단위로 자른 문자열의 길이
	public static int compress(String str, int num) {
		int count = 1;
		String total = "";
		int i = 0;
		for(i = 0 ; i + num*2 <= str.length() ; i += num) {
			String a = str.substring(i, i+num);
			String b = str.substring(i+num, i+num*2);
			if(a.equals(b)) {
				count++;
			}
			else {
				if(count != 1)
					total += String.valueOf(count);
				total += a;
				count = 1;
			}
		}
		// 남은 문자처리
		if(count != 1) 
			total += String.valueOf(count);
		total += str.substring(i);
		
		return total.length();
	}
	
	// str문자열을 잘라서 최소길이를 구하는 함수
	public static int findMin(String str) {
		int minLen = 987654321;
		int cLen = 0;
		// 어차피 str의 길이의 1/2이 넘어가면 줄어들지 않으므로 1/2까지만 세기
		for(int i = 1 ; i <= (str.length() / 2) ; i++) {
			cLen = compress(str, i);
			if(cLen < minLen)
				minLen = cLen;
		}
		return minLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(findMin(str));
		sc.close();
	}

}

// aabbaccc -> 2a2ba3c (7)
// abcabcaa -> 2abcaa (6)
// ababcdcdababcdcd -> 2ababcdcd (9)
// abcabcabcabcdededededede -> 14
// xababcdcdababcdcd -> 17