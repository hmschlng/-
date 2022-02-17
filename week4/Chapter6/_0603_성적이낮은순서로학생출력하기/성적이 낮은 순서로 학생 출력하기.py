n = int(input())
array = []
for i in range(n):
    data = input().split()
    array.append((data[0], int(data[1]))) # 튜플로 array에 저장
# array = sorted(array, key=lambda x: x[1])

# 삽입 정렬
for i in range(1, len(array)):
    for j in range(i, 0, -1):
        if array[j][1] < array[j-1][1]:
            array[j], array[j-1] = array[j-1], array[j]
        else:
            break
for i in range(n):
    print(array[i][0], end= ' ')