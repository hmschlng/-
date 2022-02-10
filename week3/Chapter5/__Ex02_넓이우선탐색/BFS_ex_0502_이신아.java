// p. 147 BFS 예제 -> 그래프의 너비우선 탐색
package Chapter5;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFS_ex_0502 {
	
	public static boolean[] visited = new boolean[9];

	public static void bfs(int[][] graph, int v) {
		Deque<Integer> deq = new ArrayDeque<>();
		deq.offer(v);							// 선입선출방식 -> 뒤에서 넣고 앞에서 빼기
		System.out.print(v + " ");	
		visited[v] = true; 
		
		while(!deq.isEmpty()) {
			v = deq.pollFirst();				// 선입선출방식 -> 뒤에서 넣고 앞에서 빼기
//			System.out.print(v + " ");
			for(int i = 0 ; i < graph[v].length ; i++) 
				if(!visited[graph[v][i]]) {
					visited[graph[v][i]] = true; 
					deq.offer(graph[v][i]);
					System.out.print(graph[v][i] + " ");
				}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = { 
				{},
				{2,3,8},
				{1,7},
				{1,4,5},
				{3,5},
				{3,4},
				{7},
				{2,6,8},
				{1,7}
			};
		bfs(graph, 1);
	}

}
