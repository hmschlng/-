package _1102_곱하기혹은더하기;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] S = scanner.nextLine().split("");

    int result = 0;
    for (int i = 0; i < S.length; i++) {
      int s = Integer.parseInt(S[i]);
      if(result == 0 || s == 0) {
        result += s;
      } else {
        result *= s;
      }
    }
    System.out.println(result);
  }
}
// 풀이시간 : 8분 30초
// TC      : O(N) (선형탐색), 1 <= N <= 20
// SC      : O(N) (String[N]), 1 <= N <= 20