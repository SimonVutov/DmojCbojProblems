n, k = map(int, input().split())
tests = sorted(map(int, input().split()))

days = 0
prev_test = 0
for test in tests:
    if test == 1:
        continue
    days_needed = k - (test - prev_test)
    if days_needed > 0:
        days += days_needed
        prev_test = test - days_needed
    else:
        prev_test = test

print(days)
