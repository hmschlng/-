package _1319_연산자끼워넣기;

import java.util.*;

//순열 계산 클래스 (제네릭)
class Permutation<T> {
  private Integer n;
  private Integer r;
  private ArrayList<T> list;
  private ArrayList<T> now;
  private ArrayList<ArrayList<T>> result;

  public Permutation(ArrayList<T> list, Integer r) {
    this.n = list.size();
    this.r = r;
    this.list = list;
    this.now = new ArrayList<>(r);
    this.result = new ArrayList<>();
  }

  // 순열 계산
  private void permutation(Integer depth) {
    if(depth == r) {
      result.add(new ArrayList<>(now));
      return;
    }

    for (int i = depth; i < n; i++) {
      Collections.swap(list, i, depth);
      now.add(list.get(depth));
      permutation(depth+1);
      now.remove(now.size()-1);
      Collections.swap(list, i, depth);
    }
  }

  public ArrayList<ArrayList<T>> result() {
    permutation(0);
    return result;
  }
}

class Main {
  public static ArrayList<Integer> operators = new ArrayList<>(); //피연산자들
  public static Long[] operands;                                  //연산자들 (+,-,*,/)
  public static ArrayList<Long> results = new ArrayList<>();      //수식의 결과값들

  //두 숫자와 연산자 번호를 받아 사칙연산을 수행하는 함수
  public static Long calculate(Long lhs, Long rhs, Integer optr) {
    Long result = 0L;
    //사칙연산 계산
    switch (optr) {
      case 0: result = lhs+rhs; break;  // +
      case 1: result = lhs-rhs; break;  // -
      case 2: result = lhs*rhs; break;  // *
      case 3: result = lhs/rhs; break;  // /
    }
    return result;
  }

  public static void main(String[] args) {
    // 입력값 저장
    Scanner sc = new Scanner(System.in);
    Integer[] line = Arrays.stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .boxed()
            .toArray(Integer[]::new);
    Integer N = line[0];

    //피연산자들 저장
    operands = Arrays.stream(sc.nextLine().split(" "))
            .mapToLong(Long::parseLong)
            .boxed()
            .toArray(Long[]::new);

    //사칙연산 연산자들을 차례로 하나씩 저장
    for (int i = 0; i < 4; i++) {
      int count = sc.nextInt();
      while(count > 0) {
        operators.add(i);
        count--;
      }
    }

    //연산자의 순서를 고려하려 줄세우는 경우의 수 계산
    ArrayList<ArrayList<Integer>> permutations = new Permutation<Integer>(operators, operators.size()).result();

    //순열의 원소들(연산자 배열)을 하나하나 체크하며
    for (ArrayList<Integer> permutation : permutations) {
      Integer idx = 1;  //피연산자 포인터 (operands 의 index)

      //첫 번째 피연산자를 result 에 먼저 저장
      Long result = operands[0]; //result : 수식의 결과값

      for(Integer operator : permutation) { //순열표 하나에 있는 연산자들을 순서대로 돌며
        //피연산자를 모두 조회했다면 break
        if(idx == N) break;

        //피연산자를 하나씩 돌며 계산 결과를 적용시켜 나간다.
        result = calculate(result, operands[idx], operator);
        idx++;
      }
      //계산 결과를 results에 저장
      results.add(result);
    }

    //results 오름차순 정렬
    Collections.sort(results);
    //최대값 출력 (마지막 원소)
    System.out.println(results.get(results.size() - 1));
    //최소값 출력 (첫 번째 원소)
    System.out.println(results.get(0));
  }
}
