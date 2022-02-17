n = input()
num = 0  # n의 숫자의 합 저장
result = []
for i in n:
    if i.isalpha():
        result.append(i)
    else:
        num += int(i)
result.sort()
result.append(str(num))
print(''.join(result))