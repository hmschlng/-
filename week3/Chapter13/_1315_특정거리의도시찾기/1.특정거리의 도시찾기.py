from collections import deque
n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n+1)]
result = []
visited = [-1] * (n+1)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

#최단거리 -> bfs
q = deque([x])
visited[x] = 0
while q:
    city = q.popleft()
    for i in graph[city]:
        if visited[i] == -1:
            q.append(i)
            visited[i] = visited[city] + 1

for j in range(1, n+1):
    if visited[j] == k:
        result.append(j)
if result == []:
    print(-1)
print(''.join(result))

