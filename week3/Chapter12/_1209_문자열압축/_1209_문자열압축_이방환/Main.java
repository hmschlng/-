package _1209_문자열압축._1209_문자열압축_이방환;

public class Main {
  public static void main(String[] args) {
    String s1 = "aabbaccc";
    String s2 = "ababcdcdababcdcd";
    String s3 = "abcabcdede";
    String s4 = "abcabcabcabcdededededede";
    String s5 = "xababcdcdababcdcd";

    Solution myCode = new _1209_문자열압축._1209_문자열압축_이방환.Solution();
    System.out.println(myCode.solution(s1));
    System.out.println(myCode.solution(s2));
    System.out.println(myCode.solution(s3));
    System.out.println(myCode.solution(s4));
    System.out.println(myCode.solution(s5));

    /*Solution answer = new _1209_문자열압축.answer.Solution();
    System.out.println(answer.solution(s1));
    System.out.println(answer.solution(s2));
    System.out.println(answer.solution(s3));
    System.out.println(answer.solution(s4));
    System.out.println(answer.solution(s5));*/
  }
}
