n = int(input())

if n % 2 == 0:
    arr = [1] * (n // 2) + [-1] * (n // 2)
else:
    arr = [1] * ((n - 1) // 2) + [-(n - 1) // 2] + [-1] * ((n - 1) // 2)

print(*arr)
