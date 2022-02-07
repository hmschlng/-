package _0502_미로탈출;

import java.util.*;

class Main {
  public static int N, M;                    // 지도의 행, 열
  public static Integer[][] map;             // 지도 정보
  public static boolean[][] visited;         // 방문한 좌표 정보
  public static final int[] dx = {-1,1,0,0}, // 2차원 좌표 방향제어 (상하좌우)
                            dy = {0,0,-1,1};
  public static Integer[] start;             // 출발점 좌표
  public static Integer[] exit;              // 도착점 좌표

  public static void BFS() {
    Queue<Integer[]> queue = new LinkedList<>();
    queue.add(start);
    visited[0][0] = true;

    while(!queue.isEmpty()) {
      Integer[] now = queue.poll();

      //상하좌우 이동에 대해 확인
      for (int i = 0; i < 4; i++) {
        //유효한 이동이 가능한 방향일 때
        if(now[0] + dx[i] >= 0 && now[1] + dy[i] >= 0 && now[0] + dx[i] < N && now[1] + dy[i] < M) {
          //한 번도 방문하지 않은 좌표이고 벽이 아니면
          if(map[now[0] + dx[i]][now[1] + dy[i]] == 1 && visited[now[0] + dx[i]][now[1] + dy[i]] == false) {
            //큐에 해당 이동좌표를 추가
            queue.add(new Integer[] {
                    now[0] + dx[i],
                    now[1] + dy[i]
            });

            //방문처리
            visited[now[0] + dx[i]][now[1] + dy[i]] = true;
            //맵의 좌표에 거리값 (now + 1) 을 저장한다.
            map[now[0] + dx[i]][now[1] + dy[i]] = map[now[0]][now[1]] + 1;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] size = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = size[0];
    M = size[1];

    map = new Integer[N][M];
    for (int i = 0; i < N; i++) {
      map[i] = Arrays.stream(sc.nextLine().split(""))
              .mapToInt(Integer::parseInt)
              .boxed()
              .toArray(Integer[]::new);
    }

    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      Arrays.fill(visited[i], false);
    }

    start = new Integer[]{0,0};
    exit  = new Integer[]{N-1, M-1};

    BFS();

    System.out.println(map[N-1][M-1]);
  }
}
// 풀이 시간 : 1시간 10분