package _1105_볼링공고르기;

import java.util.*;

class _1105_볼링공고르기_이방환 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt(),
        M= scanner.nextInt();

    List<Integer> balls = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      balls.add(scanner.nextInt());
    }

    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i; j < N; j++) {
        if(! balls.get(i).equals(balls.get(j))) count++;
      }
    }

    System.out.println(count);
  }
}
// 풀이 시간 : 10분
// TC       : O(N^2)
// SC       : O(N)
