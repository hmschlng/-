package _1101_모험가길드;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 사용자 입력받기
    int N = scanner.nextInt();
    List<Integer> players = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      players.add(scanner.nextInt());
    }

    // 그룹 나누기
    int count = 0;
    players.sort((x, y) -> x-y);

    while(N != 0) {
      N -= players.get(N-1);
      count++;
    }
    System.out.println(count);
  }
}
// 풀이시간 : 6분 30초
// TC : O(N) (입력시간), 1 <= N <= 100,000
// SC : O(N) (크기 N인 배열), 4 <= N <= 400,000 (byte)