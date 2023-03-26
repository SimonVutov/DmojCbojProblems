def max_score(n, k, w, pins):
    dp = [0] * (n + 1)
    prefix_sum = [0] * (n + 1)
    for i in range(1, n + 1):
        prefix_sum[i] = prefix_sum[i - 1] + pins[i - 1]
    for i in range(1, k + 1):
        max_so_far = float('-inf')
        for j in range(1, n + 1):
            if j < w:
                max_so_far = max(max_so_far, prefix_sum[j])
            else:
                max_so_far = max(max_so_far, prefix_sum[j] - prefix_sum[j - w])
            dp[j] = max(dp[j], max_so_far + dp[j - 1])
    return dp[n]

t = int(input())
for i in range(t):
    n, k, w = map(int, input().split())
    pins = [int(input()) for _ in range(n)]
    print(max_score(n, k, w, pins))
