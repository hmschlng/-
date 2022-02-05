package _1104_만들수없는금액;

import java.util.*;

class _1104_만들수없는금액_이방환 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    List<Integer> coins = new ArrayList<>();
    for (int i = 0; i < N; i++) coins.add(sc.nextInt());

    coins.sort((x,y)->x-y);
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += coins.get(i);
    }

    Boolean[] arr = new Boolean[sum+2];
    Arrays.fill(arr, false);

    int range = 1;
    int cur = 0;
    while(range <= N) {
      for (int i = 0; i < N-range+1; i++) {
        sum = 0;
        for (int j = cur; j < cur + range; j++) {
          sum += coins.get(j);
        }
        if(arr[sum] == false) {
          arr[sum] = true;
        }
        cur++;
      }
      cur=0;
      range++;
    }
    for (int i = 1; i < arr.length; i++) {
      if(arr[i] == false) {
        System.out.println(i);
        break;
      }
    }
  }
}
// 풀이 시간 : 시간 초과 (41분)
// TC       : O(N^3) 시간 복잡도 초과
// SC       : O(N) (Boolean 배열), 1 <= N <= 1,000,000,000
