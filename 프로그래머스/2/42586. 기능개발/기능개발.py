from math import ceil
def solution(progresses, speeds):
    answer = []
    acc = 0
    idx = 0
    
    while idx < len(progresses):
        current = 1
        left = 100 - progresses[idx] - speeds[idx] * acc;
        acc = acc + (1 if left//speeds[idx] == 0 else ceil(left / speeds[idx]))
        next = idx + 1
        while next < len(progresses):
            if acc * speeds[next] + progresses[next] >= 100:
                idx+=1
                next+=1
                current+=1
            else:
                break
        answer.append(current)
        idx+=1
        
    return answer