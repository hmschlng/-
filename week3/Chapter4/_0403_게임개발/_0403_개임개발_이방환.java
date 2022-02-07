package _0403_게임개발;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 입력
    int N = sc.nextInt(), // 맵의 세로 크기
        M = sc.nextInt(); // 맵의 가로 크기
    int A = sc.nextInt(), // 캐릭터 좌표
        B = sc.nextInt(), // 캐릭터 좌표
        d = sc.nextInt(); // 캐릭터의 초기 방향

    // 맵 정보 입력
    int[][] map = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        map[i][j] = sc.nextInt();
      }
    }

    // 캐릭터의 현재 좌표
    int[] location = { A, B };
    // 캐릭터가 이동한 칸의 수 (시작지점의 1 포함)
    int step = 1;

    // 처음 시작 좌표를 방문한 좌표로 계산
    map[location[0]][location[1]] = -1;

    // 게임 종료 까지 무한 반복
    while (true) {
      int newDirection = d; // 변경한 방향
      boolean canMove = false; // 이동 경로를 찾았는지 여부

      // 1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향으로 돈다.
      for (int i = 0; i < 4; i++) { // 4번 반복
        // 왼쪽으로 방향 회전
        newDirection = turnLeft(newDirection);

        // 테스트를 위해 현재 로케이션 복사
        int[] trial = location.clone();

        // 캐릭터 이동 테스트
        // - 현재 정해진 방향으로 한칸 이동해본다.
        // - 만약 이동한 칸이 육지라면
        // - 현재 방향으로 방향(d) 변환
        // - 이동 가능 상태(canMove) = true;
        trial = move(map, trial, newDirection, 1);
        if (map[trial[0]][trial[1]] == 0) {
          d = newDirection;
          canMove = true;
          break;
        }
      }
      // 2. 앞의 반복문에서 이동 가능 상태라면
      // - 캐릭터 위치를 이동
      // - 현재 위치를 -1 로 표기
      // - step 증가 (이동한 칸의 수)
      if (canMove == true) {
        location = move(map, location, d, 1);
        map[location[0]][location[1]] = -1;
        step++;
      }

      // 3. 이동 가능 상태가 아니라면
      else {
        // 기존 방향에서 왼쪽으로 한번 돈다.
        d = turnLeft(d);

        // location 복사
        int[] trial = location.clone();

        // 왼쪽으로 돈 방향에서 뒤로 한 칸 이동해본다.
        trial = move(map, trial, d, -1);

        // 4. 뒤칸이 탐험한 칸이라면, 이동한 채로 다시 1단계로 돌아간다.
        if (map[trial[0]][trial[1]] == -1) {
          location = trial;
        }
        // 5. 뒤칸이 바다(1)이라면, 종료한다.
        else if (map[trial[0]][trial[1]] == 1) {
          break;
        }
      }
    }
    System.out.println(step);
  }

  public static int turnLeft(int dir) {
    // 왼쪽으로 방향 회전
    return (dir == 0) ? 3 : (dir - 1);
  }

  public static int[] move(int[][] map, int[] loc, int dir, int step) {
    // 방향에 따라 좌표의 위치를 변경
    switch (dir) {
      // 북쪽
      case 0: {
        loc[0] -= step;
        break;
      }
      // 동쪽
      case 1: {
        loc[1] += step;
        break;
      }
      // 남쪽
      case 2: {
        loc[0] += step;
        break;
      }
      // 서쪽
      case 3: {
        loc[1] -= step;
        break;
      }
    }
    return loc;
  }
}
