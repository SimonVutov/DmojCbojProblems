MOD = 1000000007

def sum_of_ranges(n, heights):
    # Calculate prefix sums of heights and squared heights
    prefix_sum = [0] * (n+1)
    prefix_sum_squared = [0] * (n+1)
    for i in range(1, n+1):
        prefix_sum[i] = (prefix_sum[i-1] + heights[i-1]) % MOD
        prefix_sum_squared[i] = (prefix_sum_squared[i-1] + heights[i-1] * heights[i-1]) % MOD
    
    # Calculate the sum of ranges
    sum_of_ranges = 0
    for i in range(1, n+1):
        sum_of_ranges += ((i-1)*heights[i-1]*heights[i-1] % MOD - 2*heights[i-1]*prefix_sum[i-1] % MOD + prefix_sum_squared[i-1]*(i-1) % MOD) % MOD
        sum_of_ranges %= MOD
    
    # Return the sum of ranges modulo MOD
    return sum_of_ranges

# Example usage
n = int(input())
heights = list(map(int, input().split()))
print(sum_of_ranges(n, heights))
