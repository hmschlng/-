package _1315_특정거리의도시찾기;

import java.util.*;

class Main {
  public static final int INF = 987654321;  // 무한대
  public static int N,M,K,X;
  public static Integer[][] graph;          //
  public static Integer[] visited;          //

  public static void BFS(int start) {
    Queue<Integer> queue = new LinkedList<>();
    visited[start] = 0;
    queue.add(start);

    while(!queue.isEmpty()) {
      Integer vertex = queue.poll();
      for (int i = 0; i < graph[vertex].length; i++) {
        if(graph[vertex][i] == 1 && visited[i] == INF) {
          queue.add(i);
          visited[i] = visited[vertex] + 1;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    K = sc.nextInt();
    X = sc.nextInt()-1;

    //그래프 생성, INF, 0 초기화
    graph = new Integer[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(graph[i], INF);
      for (int j = 0; j < N; j++) {
        if(i==j) graph[i][j] = 0;
      }
    }

    //그래프의 연결선 정보 저장
    for (int i = 0; i < M; i++) {
      int A = sc.nextInt()-1;
      int B = sc.nextInt()-1;
      graph[A][B] = 1;
    }

    //visited의 원소 값을 INF로 초기화
    visited = new Integer[N];
    Arrays.fill(visited, INF);

    //넓이우선탐색
    //첫 정점과 연결된 점들에 점점 증가하는 거리값 적용시킴
    //큐에 넣을때마다 거리 증가
    BFS(X);

    //결과 출력
    int count = 0; //최단거리가 K인 도시들의 개수
    for (int i = 0; i < visited.length; i++) {
      if(visited[i] == K) {
        System.out.println(i+1);
        count++;
      }
    }
    if(count==0) System.out.println(-1);
  }
}
// 풀이시간 : 29분
