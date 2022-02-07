package _1316_연구소;

import java.util.*;

// 2차원 배열의 좌표 원소
class Point {
  Integer x;    //행
  Integer y;    //열

  public Point(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }
}

// 조합 연산 클래스(제네릭)
class Combination<T> {
  private Integer n;                         // 집단의 개수
  private Integer r;                         // 선택하는 개수
  private ArrayList<T> list;                 // 집단의 내용
  private ArrayList<T> now;                  // list에서 현재 선택된 원소들
  private ArrayList<ArrayList<T>> result;    // 선택한 결과들

  public Combination (ArrayList<T> list, Integer r) {
    this.n = list.size();
    this.r = r;
    this.list = list;
    this.now = new ArrayList<>(r);
    this.result = new ArrayList<>();
  }

  private void calculate(Integer depth, Integer target) {
    if(depth == r) {
      result.add(new ArrayList<>(now));
      return;
    }

    if(target == n) return;

    now.add(list.get(target));
    calculate(depth + 1, target + 1);
    now.remove(now.size()-1);
    calculate(depth, target + 1);
  }

  public ArrayList<ArrayList<T>> result() {
    calculate(0,0);                    // list의 처음 인덱스부터 모든 조합을 계산하고
    return this.result;                             // 그 결과인 result를 return
  }
}

class Main {

  public static Integer N,M;                // map의 행, 열
  public static Integer[][] map;            // 지도 정보(0:빈공간, 1:벽, 2:바이러스)
  public static ArrayList<Point> spaces;    // 빈칸의 좌표들
  public static ArrayList<Point> viruses;   // 바이러스의 좌표들
  public static Integer[] dx = {-1,1,0,0},  // 상하좌우(x)
                          dy = {0,0,-1,1};  // 상하좌우(y)

  // 바이러스 전파를 위한 BFS Method
  // 넓이우선탐색을 하며 바이러스를 퍼뜨린다
  // graph : 탐색 대상(맵)
  // pos : 탐색을 시작할 최초 좌표
  public static void BFS(Integer[][] graph, Point pos) {
    Queue<Point> queue = new LinkedList<>();
    queue.add(pos);

    while(!queue.isEmpty()) {
      Point now = queue.poll();
      for (int i = 0; i < 4; i++) {
        Point newPos = new Point(now.x + dx[i],now.y + dy[i]);
        if(newPos.x >= 0 && newPos.x < N && newPos.y >= 0 && newPos.y < M) {
          if (graph[newPos.x][newPos.y] == 0) {
            queue.add(newPos);
            graph[newPos.x][newPos.y] = 2;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //N, M 입력
    Integer[] size = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toArray(Integer[]::new);
    N = size[0];
    M = size[1];

    // map, spaces, viruses 에 입력 정보 저장
    map = new Integer[N][M];
    spaces = new ArrayList<>();
    viruses = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      map[i] = Arrays.stream(sc.nextLine().split(" "))
              .mapToInt(Integer::parseInt)
              .boxed()
              .toArray(Integer[]::new);;
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          spaces.add(new Point(i, j));
        } else if (map[i][j] == 2) {
          viruses.add(new Point(i, j));
        }
      }
    }

    // 빈 칸 중에서 3개의 칸을 고르는 모든 조합 구하기
    ArrayList<ArrayList<Point>> combination = new Combination<Point>(spaces, 3).result();
    ArrayList<Integer> results = new ArrayList<>();    //전파 이후 빈 공간의 개수의 합을 저장

    for (ArrayList<Point> wallPoints : combination) {
      // appliedMap : 벽 3개를 설치한 맵의 모습
      Integer[][] appliedMap = new Integer[N][M];
      for (int i = 0; i < N; i++) { //deep copy
        for (int j = 0; j < M; j++) {
          appliedMap[i][j] = map[i][j];
        }
      }

      //벽 설치하기
      for(Point pos : wallPoints) {
        appliedMap[pos.x][pos.y] = 1;
      }

      //바이러스 전파
      for(Point pos : viruses) {
        BFS(appliedMap, pos);
      }

      //빈 공간(0) 개수 세기
      Integer count = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if(appliedMap[i][j] == 0) {
            count++;
          }
        }
      }
      results.add(count);    //조합별 빈칸의 합을 result에 저장
    }

    //빈 공간의 최대값 출력
    Collections.sort(results, (x,y) -> y-x);    //내림차순정렬
    System.out.println(results.get(0));
  }
}
