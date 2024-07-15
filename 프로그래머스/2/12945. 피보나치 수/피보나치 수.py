def solution(n):
    fiboDict = [-1 for _ in range(n+1)]
    fiboDict[0] = 0
    fiboDict[1] = 1

    for i in range(2, n+1):
        fiboDict[i] = (fiboDict[i-1] + fiboDict[i-2])%1234567

    return fiboDict[n]