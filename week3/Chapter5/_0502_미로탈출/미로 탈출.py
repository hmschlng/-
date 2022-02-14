# BFS
from collections import deque
n, m = map(int, input().split())
graph = []  # 괴물이 있으면 0, 괴물이 없으면 1 -> 맵 정보
for _ in range(n):
    graph.append(list(map(int, input())))

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
q = deque()
q.append((0, 0))
while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= n or ny >= m or nx < 0 or ny < 0:
            continue
        if graph[nx][ny] == 0:
            continue
        if graph[nx][ny] == 1:
            graph[nx][ny] = graph[x][y] + 1
            q.append((nx, ny))
print(graph[n-1][m-1])