package _1209_문자열압축.newCode;

import java.util.*;

//부분문자열 클래스
class SubStr {
  String str; //부분문자열
  int count;  //반복횟수

  public SubStr(String str, int count) {
    this.str = str;
    this.count = count;
  }
}

class Solution {
  private ArrayList<SubStr> substrings = new ArrayList<>(); // 잘린 부분문자열들이 저장된 배열
  private ArrayList<Integer> lengths = new ArrayList<>(); // 압축된 문자열의 길이들

  public int solution(String s) {
    //s의 길이가 1이면 1 리턴
    if(s.length() == 1) return 1;

    //문자열을 자르는 단위
    int size = 1;

    //문자열의 절반 + 1까지 단위(size)를 증가시키며 반복
    while(size <= s.length()/2 + 1) {
      //첫 번째 부분분자열을 substrings 에 추가
      String substring = s.substring(0, size);
      substrings.add(new SubStr(substring, 1));

      //단위만큼씩 s를 자른다.
      for (int i = size; i < s.length(); i += size) {
        //마지막 부분문자열의 처리
        if(i + size >= s.length()) {
          substring = s.substring(i);
          process(substring);
          break;
        }
        //부분문자열의 처리
        substring = s.substring(i, i+size);
        process(substring);
      }

      //압축된 문자열의 길이를 계산 후 length 에 저앙
      Integer length = 0;
      for(SubStr sub : substrings) {
        length += sub.str.length();
        // 2회 이상 반복된 부분문자열에 대해 숫자의 자릿수 추가
        length += (1 < sub.count) ?
                Integer.toString(sub.count).length() : 0;
      }
      lengths.add(length);

      //substrings 비우기
      substrings.clear();

      //단위 증가
      size++;
    }

    //전체 문자열의 길이 추가
    lengths.add(s.length());

    //lengths 의 최소값 구하기 (length 비우기)
    Collections.sort(lengths);
    int min = lengths.get(0);

    //lengths 초기화
    lengths.clear();

    //최소값 리턴
    return min;
  }

  //부분문자열을 처리하는 메소드
  private void process(String str) {
    //마지막 부분문자열
    SubStr prev = substrings.get(substrings.size()-1);
    //prev.str 이 str 과 같으면 prev.count 추가
    if(prev.str.equals(str)) {
      prev.count++;
    }
    //str 이 새로운 문자열이면 substrings 에 새로운 원소 추가
    else {
      substrings.add(new SubStr(str, 1));
    }
  }
}

//-------------------------------------------------------------------------

class Main {
  public static void main(String[] args) {
    String s1 = "abababababababababababababababababababababababababababababab";
    String s2 = "ababcdcdababcdcd";
    String s3 = "abcabcdede";
    String s4 = "abcabcabcabcdededededede";
    String s5 = "xababcdcdababcdcd";

    Solution s = new Solution();

//    System.out.println(s.solution(s1));
    System.out.println(s.solution(s2));
    System.out.println(s.solution(s3));
    System.out.println(s.solution(s4));
    System.out.println(s.solution(s5));
  }
}