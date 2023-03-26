def snow_removal(N, A):
    time = 0
    left = 0
    right = N - 1
    while left <= right:
        if left == right:
            time += A[left]
        elif A[left] < A[right]:
            time += A[left] * 2
            A[right] -= A[left]
            left += 1
        else:
            time += A[right] * 2
            A[left] -= A[right]
            right -= 1
    return time

N = int(input("Enter the number of areas: "))
A = list(map(int, input("Enter the amount of snow in each area: ").split()))
print("Minimum time to move all the snow:", snow_removal(N, A))
