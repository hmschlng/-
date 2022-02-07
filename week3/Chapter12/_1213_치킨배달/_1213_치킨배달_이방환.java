package _1213_치킨배달;

import java.util.*;
import java.util.stream.*;

// 2차원 평면 좌표
class Point {
  Integer x;
  Integer y;

  public Point(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }
}

// 조합 연산 (제네릭)
class Combination<T> {
  private Integer n;
  private Integer r;
  private ArrayList<T> list;
  private ArrayList<T> now;
  private ArrayList<ArrayList<T>> result;

  public Combination(ArrayList<T> list, Integer r) {
    this.n = list.size();
    this.r = r;
    this.list = list;
    this.now = new ArrayList<>(r);
    this.result = new ArrayList<ArrayList<T>>();
  }

  private void calculate(Integer depth, Integer target) {
    if (depth == this.r) {
      result.add(new ArrayList<T>(now));
      return;
    }
    if (target == this.n)
      return;

    now.add(list.get(target));
    calculate(depth + 1, target + 1);
    now.remove(now.size() - 1);
    calculate(depth, target + 1);
  }

  public ArrayList<ArrayList<T>> getResult() {
    calculate(0, 0);
    return result;
  }
}

class Main {
  public static int N, M;
  public static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>(); // 지도 정보
  public static ArrayList<Point> houses = new ArrayList<>(); // 집의 좌표들
  public static ArrayList<Point> stores = new ArrayList<>(); // 치킨집의 좌표들
  public static ArrayList<Integer> chickenDistances = new ArrayList<>(); // 치킨 거리들

  // 치킨거리의 합을 구하는 메소드
  public static Integer getSum(ArrayList<Point> stores) {
    Integer sum = 0; // 치킨거리의 합
    Integer min; // 치킨거리의 최소값

    // 모든 집을 탐색
    for (Point house : houses) {
      min = 987654321;

      // 모든 치킨집을 탐색
      for (Point store : stores) {
        Integer dist = Math.abs(store.x - house.x) + Math.abs(store.y - house.y);
        // 치킨거리의 최소값을 계산
        if (min > dist) {
          min = dist;
        }
      }
      // 모든 집의 치킨거리를 합산
      sum += min;
    }

    return sum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer[] line = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed()
        .toArray(Integer[]::new);
    N = line[0];
    M = line[1];

    for (int i = 0; i < N; i++) {
      map.add(new ArrayList<>(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().toList()));
      for (int j = 0; j < N; j++) {
        Integer value = map.get(i).get(j);
        if (value == 1) {
          houses.add(new Point(i, j));
        }
        if (value == 2) {
          stores.add(new Point(i, j));
        }
      }
    }

    // 치킨집을 N개 선택하는 경우의 수를 모두 계산
    ArrayList<ArrayList<Point>> combinations = new Combination<Point>(stores, M).getResult();

    // 모든 경우의 수에 대해 치킨거리의 합을 chickenDistances에 저장
    for (ArrayList<Point> comb : combinations) {
      chickenDistances.add(getSum(comb));
    }

    // 오름차순 정렬
    Collections.sort(chickenDistances);

    // 최소값 출력
    System.out.println(chickenDistances.get(0));
  }
}
// 풀이 시간 : 37분