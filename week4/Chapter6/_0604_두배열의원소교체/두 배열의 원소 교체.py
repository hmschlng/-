n, k = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
result = 0
# a의 k개의 작은 원소들 추출
# a의 선택 정렬 => 오름 차순 정렬
for i in range(len(a)):
    min_value = i
    for j in range(i+1, len(a)):
        if a[min_value] > a[j]:
            min_value = j
    a[min_value], a[i] = a[i], a[min_value]
# a.sort()

# b의 선택 정렬 => 내림 차순 정렬
for i in range(len(b)):
    max_value = i
    for j in range(i+1, len(b)):
        if b[max_value] < b[j]:
            max_value = j
    b[max_value], b[i] = b[i], b[max_value]
# b.sort(reverse = True)

for i in range(k):
    if a[i] < b[i]:
        a[i], b[i] = b[i], a[i]
    else:
        break
print(sum(a))
