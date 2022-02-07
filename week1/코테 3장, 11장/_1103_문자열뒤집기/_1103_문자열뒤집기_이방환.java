package _1103_문자열뒤집기;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] S = scanner.nextLine().split("");

    String cur = S[0];
    int zero = cur.equals("0") ? 1 : 0,
          one = cur.equals("1") ? 1 : 0;

    for (String s: S) {
      if(!s.equals(cur)) {
        if(s.equals("1")) {
          one++;
        } else {
          zero++;
        }
      }
      cur = s;
    }

    if(zero > one) {
      System.out.println(one);
    } else {
      System.out.println(zero);
    }
  }
}
// 풀이 시간 : 11분 30초
// TC       : O(N) (선형탐색), 1 <= N < 1,000,000
// SC       : O(N) (String[N]), 1 <= N <= 1,000,000 (bytes)