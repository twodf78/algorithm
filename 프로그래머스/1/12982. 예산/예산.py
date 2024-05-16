def solution(d, budget):
    answer = 0
    d.sort()
    for num in d:
        if budget >= num:
            budget -= num
            answer += 1
        else: 
            break
    return answer