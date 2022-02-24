package _0802_1로만들기;

import java.util.Scanner;

class _0802_1로만들기 {
  public static void main(String[] args) {
    // 입력값 저장
    int X = new Scanner(System.in).nextInt();

    // DP 테이블 선언
    int[] DPTable = new int[X+1];

    // DP 테이블 채우기
    for (int i = 2; i <= X; i++) {
      DPTable[i] = DPTable[i-1] + 1;
      if(i%2==0) DPTable[i] = Math.min(DPTable[i], DPTable[i/2] + 1);
      if(i%3==0) DPTable[i] = Math.min(DPTable[i], DPTable[i/3] + 1);
      if(i%5==0) DPTable[i] = Math.min(DPTable[i], DPTable[i/5] + 1);
    }
    System.out.println(DPTable[X]);
  }
}
