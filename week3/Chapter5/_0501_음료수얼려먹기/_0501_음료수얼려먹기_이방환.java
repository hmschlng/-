package _0501_음료수얼려먹기;

import java.util.*;
import java.util.stream.Stream;

class Main {
  public static Integer[][] tray;     //얼음 트레이
  public static Boolean[][] visited;  //방문 정보
  static final int[] dx = {-1,1,0,0},
                     dy = {0,0,-1,1}; //상하좌우의 좌표 변화량

  static void DFS(int x, int y) {
    //유효한 좌표 이동범위를 벗어나면 return
    if( x < 0 || y < 0 || x >= tray.length || y >= tray[0].length) return;

    // 현재 좌표가 0이고 방문하지 않은 좌표이면 방문처리(true)
    if(tray[x][y] == 0 && visited[x][y] == false) {
      visited[x][y] = true;

      //상하좌우 재귀적 확인
      DFS((x + dx[0]), (y + dy[0]));  //상
      DFS((x + dx[1]), (y + dy[1]));  //하
      DFS((x + dx[2]), (y + dy[2]));  //좌
      DFS((x + dx[3]), (y + dy[3]));  //우
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 트레이의 사이즈 정보 입력 받기
    int[] size = Arrays.stream((sc.nextLine().split(" "))).mapToInt(Integer::parseInt).toArray();
    int N = size[0],
        M = size[1];

    // 얼음 트레이 정보 입력, 트레이 생성
    tray = new Integer[N][M];
    for (int i = 0; i < N; i++) {
      Integer[] line = Stream.of(sc.nextLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
      tray[i] = line;
    }

    // visited를 false로 초기화
    visited = new Boolean[N][M];
    for (int i = 0; i < N; i++) {
      Arrays.fill(visited[i], false);
    }

    int count = 0; // 아이스크림 개수

    // 얼음 트레이 순차 탐색
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        // 0인 부분에 대해 DFS를 실시하고 count 증가
        if(tray[i][j] == 0 && visited[i][j] == false) {
          count++;
          DFS(i, j);
        }
      }
    }

    // 아이스크림 개수 출력
    System.out.println(count);
  }
}
//풀이시간 : 1시간