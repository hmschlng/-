// p. 142 DFS 예제 -> 그래프의 깊이우선 탐색
package Chapter5;

public class DFS_ex_0501 {
	public static boolean[] visited = new boolean[9];

	public static void dfs(int[][] graph, int v) {
		visited[v] = true; 
		System.out.print(v + " ");
		for(int i = 0 ; i < graph[v].length ; i++) {
			if(!visited[graph[v][i]])
				dfs(graph, graph[v][i]);
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
		dfs(graph, 1);
	}

}
