n = int(input())
array = []
for _ in range(n):
    array.append(int(input()))
# array.sort(), array = sorted(array, reverse = True)
# 선택 정렬
for i in range(n):
    min_value = i
    for j in range(i+1, n):
        if array[min_value] > array[j]:
            min_value = j
    array[min_value], array[j] = array[j], array[min_value]
print(array)