def solution(N, stages):
    answer = []
    userCount = len(stages)
    stages.sort()
    failure = {}
    answer = {}
    for stage in stages:
        if stage in failure:
            failure[stage] += 1
        else:
            failure[stage] = 1
    
    count = userCount
    for n in range(1, N+1):
        if n in failure:
            answer[n] = failure[n] / count
            count -= failure[n]
        else:
            answer[n] = 0
    sorted_keys = sorted(answer.keys(), key=lambda x: (-answer[x], x))

    return sorted_keys