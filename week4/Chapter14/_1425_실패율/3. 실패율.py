n = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
result = []
number = len(stages)
for i in range(1, n+1):
    count = 0
    for j in range(len(stages)):
        if stages[j] == i:
            count += 1
    fail = count / number
    result.append((i, fail))
    number -= count
result = sorted(result, key=lambda x: x[1], reverse=True)
for i in result:
    print(i[0], end=' ')