def solution(n, m, section):
    answer = 0
    painted = [True for _ in range(n + 1)]
    for idx in section:
        painted[idx] = False
        
    for i in range(n+1):
        if painted[i] == False:
            answer += 1
            for j in range(m):
                if j + i > n:
                    break
                painted[j + i] = True
    return answer