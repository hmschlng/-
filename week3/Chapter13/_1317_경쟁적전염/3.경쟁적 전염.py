from collections import deque
n, k = map(int, input().split())
graph = []
check = []
for _ in range(n):
    graph.append(list(map(int, input().split())))
s, a, b = map(int, input().split())
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for i in range(n):
    for j in range(n):
        check.append((graph[i][j], i, j))
check.sort() # 오름차순 정리

# s초 후 (a, b)에 해당하는 바이러스 번호 출력
q = deque()
q.append(check[0])
while q:
    virus, x, y = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < n and ny < n and x >= 0 and y >= 0:
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                q.append((virus, nx, ny))
    s -= 1
    if s == 0:
        break

print(graph[a-1][b-1])