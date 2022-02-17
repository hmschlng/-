n = input()
result1 = 0
result2 = 0
for i in range(len(n) // 2):
    result1 += int(n[i])
for j in range(len(n) // 2, len(n)):
    result2 += int(n[j])
if result1 == result2:
    print("LUCKY")
else:
    print("READY")
