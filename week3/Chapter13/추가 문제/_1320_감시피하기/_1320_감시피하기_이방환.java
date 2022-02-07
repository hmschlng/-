package _1320_감시피하기;

import java.util.*;

//2차원 평면 좌표
class Point {
  Integer x;
  Integer y;

  public Point(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }
}

//조합 연산 (제네릭)
class Combination<T> {
  private Integer n;
  private Integer r;
  private ArrayList<T> list;
  private ArrayList<T> now;
  private ArrayList<ArrayList<T>> results;

  public Combination(ArrayList<T> list, Integer r) {
    this.n = list.size();
    this.r = r;
    this.list = list;
    this.now = new ArrayList<>(r);
    this.results = new ArrayList<>();
  }

  private void combination(Integer depth, Integer target) {
    if(depth == r) {
      results.add(new ArrayList<>(now));
      return;
    }
    if(target == n) return;
    now.add(list.get(target));
    combination(depth+1, target+1);
    now.remove(now.size()-1);
    combination(depth, target+1);
  }

  public ArrayList<ArrayList<T>> getResults() {
    combination(0, 0);
    return results;
  }
}

class Main {
  public static Boolean result = false;                         // 학생들의 은폐 성공 여부
  public static String[][] hallway;                             // 복도의 정보
  public static ArrayList<Point> students = new ArrayList<>();  // 학생들의 좌표들
  public static ArrayList<Point> teachers = new ArrayList<>();  // 선생들의 좌표들
  public static ArrayList<Point> spaces = new ArrayList<>();    // 빈 공간의 좌표들
  public static Integer[] dx = {-1,1,0,0},
                          dy = {0,0,-1,1};

  // 선생 시야(상하좌우 직선상)에 학생이 보이는지 판별하는 메소드
  public static Boolean isDetected(Point src, String[][] map) {
    //상
    for (int i = src.x; i >= 0; i--) {
      if(map[i][src.y].equals("O")) break;
      else if(map[i][src.y].equals("S"))
        return true;
    }
    //하
    for (int i = src.x; i < map.length; i++) {
      if(map[i][src.y].equals("O")) break;
      else if(map[i][src.y].equals("S"))
        return true;
    }
    //좌
    for (int i = src.y; i >= 0; i--) {
      if(map[src.x][i].equals("O")) break;
      else if(map[src.x][i].equals("S"))
        return true;
    }
    //우
    for (int i = src.y; i < map.length; i++) {
      if(map[src.x][i].equals("O")) break;
      else if(map[src.x][i].equals("S"))
        return true;
    }
    //어느 뱡향에서도 학생이 보이지 않았다면 false
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer[] line = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
    Integer N = line[0];

    hallway = new String[N][N];

    for (int i = 0; i < N; i++) {
      hallway[i] = sc.nextLine().split(" ");
      for (int j = 0; j < N; j++) {
        //학생 좌표 저장
        if(hallway[i][j].equals("S")) students.add(new Point(i,j));
        //선생 좌표 저장
        else if(hallway[i][j].equals("T")) teachers.add(new Point(i,j));
        //빈 공간 좌표 저장
        else spaces.add(new Point(i,j));
      }
    }

    // 빈 공간에 장애물 3개를 설치하는 경우의 수를 모두 계산(조합 nC3)
    ArrayList<ArrayList<Point>> combinations = new Combination<>(spaces, 3).getResults();

    //모든 경우의 수에 대하여 장애물 설치 시뮬레이션 진행
    for (ArrayList<Point> combination : combinations) {
      //장애물을 설치할 복도 생성 (deep copy)
      String[][] installed = new String[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          installed[i][j] = hallway[i][j];
        }
      }

      //장애물 설치
      for (Point obstacle : combination) {
        installed[obstacle.x][obstacle.y] = "O";
      }

      // 모든 학생이 발각되지 않았으면 success
      Boolean success = true;
      for(Point teacher : teachers) {
        if(isDetected(teacher, installed)) {
          success = false;
        }
      }

      // success 일 경우 result 에 true 저장 후 break;
      if(success == true) {
        result = true;
        break;
      }
    }

    //결과 출력
    if(result == true) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
