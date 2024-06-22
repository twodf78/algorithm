def solution(n):
    answer = 0
    prime = [True for _ in range(n+1)]
    for i in range(2, n+1):
        if not prime[i]:
            continue
        for j in range(i+i, n+1, i):
            prime[j] = False
    cnt = len(list(filter(lambda x: x, prime)))
    return cnt - 2