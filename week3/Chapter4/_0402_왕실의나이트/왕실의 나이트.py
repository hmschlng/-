data = input()
y = int(data[1])
x = data[0]
count = 0
eng = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
num = [1, 2, 3, 4, 5, 6, 7, 8]
for i in range(len(eng)):
    if x == eng[i]:
        x = int(num[i])
dx = [2, 2, -2, -2]
dy = [-1, 1, -1, 1]
for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if nx <= 8 and ny <= 8 and nx > 0 and ny > 0:
        count += 1
for i in range(4):
    nx = x + dy[i]
    ny = y + dx[i]
    if nx <= 8 and ny <= 8 and nx > 0 and ny > 0:
        count += 1
print(count)