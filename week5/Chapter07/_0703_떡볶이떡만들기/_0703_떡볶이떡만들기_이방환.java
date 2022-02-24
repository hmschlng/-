package _0703_떡볶이떡만들기;

import java.util.*;

class _0703_떡볶이떡만들기_이방환 {
  static int N; // 떡의 개수
  static int M; // 손님이 원하는 떡의 양
  static ArrayList<Integer> riceCakes = new ArrayList<>(); // 떡의 길이들

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 입력값 저장
    N = sc.nextInt(); M = sc.nextInt();
    for (int i = 0; i < N; i++) riceCakes.add(sc.nextInt());

    // 내림차순 정렬
    Collections.sort(riceCakes, Collections.reverseOrder());

    //파라메트릭 탐색을 위한 변수 선언
    int start = 0, end = riceCakes.get(0); // 이진탐색의 scope (start와 end)
    int cutPoint = 0; //떡을 자를 절단기의 높이 (= H)

    //이진 탐색 시작
    while(start <= end) {
      // H 를 가장 긴 떡의 길이의 중간값으로 지정
      cutPoint = (int) Math.floor((start+end)/2);

      // H 에서 잘라 얻은 떡의 양
      String amount = cut(cutPoint);

      // amount 의 최적화 여부에 따라 start 와 end 의 위치를 조절하면서 재탐색
      switch(amount) {
        case "Too Much": start = cutPoint+1; break;
        case "Too Few" : end = cutPoint-1; break;
        case "Perfect" : break;
      }
    }

    // H 출력
    System.out.println(cutPoint);
  }

  static String cut(int cutPoint) {
    int amount = 0, // 떡의 길이에서 cutPoint 만큼 자른 나머지의 총합
        floor = 0;  // 떡의 길이에서 cutPoint+1 만큼 자른 나머지의 총합

    // amount 와 floor 계산
    for (int i = 0; i < riceCakes.size(); i++) {
      amount += (riceCakes.get(i) > cutPoint) ? riceCakes.get(i) - cutPoint : 0;
      floor += (riceCakes.get(i) > cutPoint+1) ? riceCakes.get(i) - (cutPoint+1) : 0;
    }

    // M > sum                    이면 "Too Few"
    //     sum >= M > floor       이면 "Perfect"
    //                floor >= M  이면 "Too Much"
    return (M > amount) ? "Too Few"
            : (M > floor ? "Perfect" : "Too Much");
  }
}
