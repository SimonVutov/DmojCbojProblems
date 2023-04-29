import math

def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(math.sqrt(n))+1):
        if n % i == 0:
            return False
    return True

def count_primes(a, b):
    count = 0
    for i in range(a, b+1):
        if is_prime(i):
            count += 1
    return count

q = int(input())
for i in range(q):
    a, b = map(int, input().split())
    print(count_primes(a, b))
