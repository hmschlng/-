package _1209_문자열압축._1209_문자열압축_이방환;

import java.util.*;

public class Solution {
  public int solution(String s) {
    //cut : 문자열을 분할할 단위
    //result : 압축된 문자열의 길이
    int cut = 1;
    List<Integer> result = new ArrayList<>();

    //자르는 단위가 문자열의 길이를 넘어서면 종료
    while(cut < s.length()) {

      //count : 부분 문자열의 반복 횟수
      //add : 압축된 부분 문자열 앞에 첨가되는 숫자 개수
      //length : 압축된 부분 문자열의 문자길이
      int count = 0, add = 0, length = 0;

      //prev : 이전에 조회한 부분 문자열
      //now : 현재 조회하고 있는 부분 문자열
      String prev = new String(),
              now = new String();

      // s를 cut만큼 잘라가며 순차 탐색
      for (int i = 0; i < s.length() ; i += cut) {
        // 1. s의 남은 부분이 분할 단위인 cut 보다 작거나 같은 경우
        if(s.substring(i).length() <= cut) {
          // s의 남은 부분과 이전에 조회한 문자열이 같은 경우
          //  - 반복 횟수 증가
          //  - 첨가되는 숫자 개수 증가
          if(s.substring(i).equals(prev)) {
            count++;
            add++;
          }
          // 다른 경우
          // - 나머지 문자열의 길이를 length에 추가
          //
          else {
            length += s.substring(i).length();
            if(count > 1) {
              add++;
            }
          }
        }
        // 2. s의 남은 부분이 충분하면
        else {
          // cut 단위만큼 부분 문자열 추출
          now = s.substring(i,i+cut);
          //동일한 문자열이면 반복 횟수 증가
          if(prev.equals(now)) {
            count++;
          }
          //이전과 문자열과 현재 문자열이 다른 경우
          // - 문자열의 길이를 length에 추가
          // - 반복 횟수 = 1로 초기화
          //연속으로 2번 이상 나온 문자열이면
          // - 첨가되는 숫자 개수 증가
          else {
            if(count > 1) {
              add++;
            }
            length += cut;
            count = 1;
          }
        }
        prev = now;
      }
      //분할 단위 증가
      cut++;

      // 압축된 문자열과 첨가되는 숫자의 개수를 더해 result에 저장
      result.add(length+add);
    }

    //압축된 문자열들의 길이를 오름차순으로 정렬
    Collections.sort(result);

    //최소값 출력
    return result.get(0);
  }
}
// 시간 초과