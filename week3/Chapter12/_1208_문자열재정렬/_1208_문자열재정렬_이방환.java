package _1208_문자열재정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().split("");

    List<Character> words = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();

    // 문자와 숫자를 나누어 저장
    for (int i = 0; i < str.length; i++) {
      char c = str[i].charAt(0);
      if ((int) c >= '0' && (int) c <= '9') {
        nums.add(Integer.parseInt(String.valueOf(c)));
      } else {
        words.add(c);
      }
    }

    // 문자부분 오름차순 정렬
    Collections.sort(words);
    for (Character c : words) {
      System.out.print(c); // 문자 하나씩 출력
    }

    // 숫자부분 원소를 모두 합산
    int sum = 0;
    for (Integer i : nums) {
      sum += i;
    }
    //
    System.out.print(sum); // 숫자들의 총합 출력
  }

}
// 풀이시간 : 15분