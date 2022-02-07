package _1317_경쟁적전염;

import java.util.*;

class Point {
  Integer x;
  Integer y;

  public Point(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }
}

class Main {
  public static Integer N,K;
  public static Integer[][] tray;
  public static ArrayList<Point> viruses;
  public static Integer S,X,Y;
  public static ArrayList<Queue<Point>> queues;
  public static Integer[] dx = {-1,1,0,0},
                          dy = {0,0,-1,1};

  public static void simulate() {
    for (Queue<Point> queue : queues) {
      ArrayList<Point> spreads = new ArrayList<>();
      while(!queue.isEmpty()) {
        spreads.add(queue.poll());
      }
      for(Point spread : spreads) {
        for (int i = 0; i < 4; i++) {
          Point pos = new Point(spread.x + dx[i], spread.y + dy[i]);
          if(pos.x >= 0 && pos.x < N && pos.y >= 0 && pos.y < N) {
            if(tray[pos.x][pos.y] == 0) {
              queue.add(pos);
              tray[pos.x][pos.y] = tray[spread.x][spread.y];
            }
          }
        }
      }
    }
  }

  //바이러스 번호를 비교하는 함수
  public static Integer virusNumberCompare(Point a, Point b) {
    return tray[a.x][a.y] - tray[b.x][b.y];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer[] size = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
    N = size[0];  //트레이 크기
    K = size[0];  //바이러스 종류

    //트레이와 바이러스 종류, 위치 정보 저장
    tray = new Integer[N][N];
    viruses = new ArrayList<>(K);
    for (int i = 0; i < N; i++) {
      tray[i] = Arrays.stream(sc.nextLine().split(" "))
              .mapToInt(Integer::parseInt)
              .boxed()
              .toArray(Integer[]::new);
      for (int j = 0; j < N; j++) {
        if(tray[i][j] != 0) {
          viruses.add(new Point(i,j));
        }
      }
    }

    // 시뮬레이션 시간, 트레이에서 확인할 좌표 저장
    size = Arrays.stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .boxed()
            .toArray(Integer[]::new);
    S = size[0];
    X = size[1]-1;
    Y = size[2]-1;

    Collections.sort(viruses, Main::virusNumberCompare);

    queues = new ArrayList<>();
    for (Point virus : viruses) {
      Queue<Point> queue = new LinkedList<>();
      queue.add(virus);
      queues.add(queue);
    }

    // S초 동안 시뮬레이션 실행
    for (int i = 0; i < S; i++) {
      simulate();
    }

    System.out.println(tray[X][Y]);
  }
}
