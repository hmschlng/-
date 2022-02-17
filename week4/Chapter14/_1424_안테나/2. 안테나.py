n = int(input())
result = []
distance = 0
array = list(map(int, input().split()))
for i in range(len(array)):
    for j in range(len(array)):
        distance += abs(array[i] - array[j])
    result.append((distance, array[i]))
result.sort()
print(result[0][1])
