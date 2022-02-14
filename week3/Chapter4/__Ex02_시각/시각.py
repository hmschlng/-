h = int(input())
count = 0
for i in range(h+1):
    for j in range(59):
        for k in range(59):
            if "3" in str(i) or "3" in str(j) or "3" in str("k"):
                count += 1
print(count)