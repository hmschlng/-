n = int(input())
x, y = 1, 1
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
direction = ["U", "L", "D", "R"]
data = input().split()
for i in data:
    for j in range(4):
        if i == direction[j]:
            nx = x + dx[j]
            ny = y + dy[j]
    if nx < 1 or ny < 1 or nx > n or ny > n:
        continue
    x, y = nx, ny
print(nx, ny)