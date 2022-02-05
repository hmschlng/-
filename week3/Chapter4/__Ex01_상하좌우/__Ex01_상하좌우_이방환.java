package __Ex01_상하좌우;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // N 과 계획서 입력받기
    int N = Integer.parseInt(scanner.nextLine());
    String[] plan = scanner.nextLine().split(" ");

    // 여행자의 좌표 X, Y
    int X = 0, Y = 0;

    // 계획서 내용의 길이만큼 반복
    for(int i = 0; i < plan.length; i++) {
      // 상하좌우에 각각에 대해
      // 유효한 이동인지 확인하고
      // X, Y 좌표를 이동시킴
      switch(plan[i]) {
        // 상
        case "U" : {
          if(Y != 0)
            Y--;
          break;
        }
        // 하
        case "D" : {
          if(Y != N-1)
            Y++;
          break;
        }
        // 좌
        case "L" : {
          if(X != 0)
            X--;
          break;
        }
        // 우
        case "R" : {
          if(X != N-1)
            X++;
          break;
        }
      }
    }

    //결과 출력
    System.out.println((X+1) + " " + (Y+1));
  }
}

