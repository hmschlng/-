package Chapter12;

import java.util.Scanner;

//https://www.acmicpc.net/problem/18406
public class LuckyStraight_1207 {

	public static void lucky(String str) {
		int len = str.length();
		String frontstr = str.substring(0, len/2);	// 123
		String backstr = str.substring(len/2);		// 402
		int front = 0;
		int back = 0;
		// 하나씩 숫자로 변환 후 다 더하기 (ex) 1+2+3
		for(int i=0 ; i<frontstr.length() ; i++) {
			String s = frontstr.substring(i, i+1);
			front += Integer.parseInt(s);
		}
		for(int i=0 ; i<backstr.length() ; i++) {
			String s = backstr.substring(i, i+1);
			back += Integer.parseInt(s);
		}
		if(front == back)
			System.out.println("LUCKY");
		else 
			System.out.println("READY");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String str = String.valueOf(num); 	// 숫자를 문자열로 변환
		lucky(str);
		sc.close();
	}

}
