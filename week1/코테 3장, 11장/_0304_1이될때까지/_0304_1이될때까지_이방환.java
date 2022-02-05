package _0304_1이될때까지;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt(),    // N : 피제수
          K = scanner.nextInt();  // K : 제수
    int count = 0;
    while(N != 1) {
      if(N % K == 0) {
        N /= K;
      } else {
        N--;
      }
      count++;
    }
    System.out.println(count);
  }
}

// 풀이 시간 : 5분
