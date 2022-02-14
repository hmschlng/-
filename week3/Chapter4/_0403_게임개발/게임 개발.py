n, m = map(int, input().split())  # 맵 정보
x, y, d = map(int, input().split())  # 캐릭터의 위치와 방향
graph = []
visited = [False for _ in range(n)]
visited[x][y] = True
result = 0  # 캐릭터가 방문한 칸의 수
for _ in range(n):
    graph.append(list(map(int, input().split)))
# 왼쪽 방향(반시계 방향)
dx = [-1, 0, 1, 0]  # 0:북 1:동 2:남 3:서
dy = [0, 1, 0, -1]

def turn_left():
    global d
    d -= 1
    if d == -1:
        d = 3

turn_time = 0
while(True):
    turn_left()
    nx = x + dx[d]
    ny = y + dy[d]
    if graph[nx][ny] == 0 and visited[nx][ny] == False:
        visited[nx][ny] = True
        x, y = nx, ny
        result += 1
        turn_time = 0
        continue
    else:
        for _ in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if graph[nx][ny] == 1 or visited[nx][ny] == True:
                turn_time += 1
                if turn_time == 4:
                    nx = x - dx[d]
                    ny = y - dy[d]
                    if graph[nx][ny] == 0:
                        x, y = nx, ny
                    else:
                        break
print(result)


