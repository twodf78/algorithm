def solution(t, p):
    answer = 0
    for i in range(len(t) - len(p) + 1):
        sub = int(t[i:i+len(p)])
        if sub <= int(p):
            answer+=1
    return answer