package __Ex01_거스름돈;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // moneyList : 사용할 수 있는 화폐의 단위
    int[] moneyList = { 500, 100, 50, 10 };
    // count : 사용한 화폐의 개수
    int count = 0;
    // N : 계산 금액
    int N = scanner.nextInt();

    // 가장 큰 화폐단위부터 차례대로 계산
    for (int i = 0; i < moneyList.length; i++) {
      count += (N / moneyList[i]);
      N %= moneyList[i];
    }

    // 출력
    System.out.println(count);
  }
}
