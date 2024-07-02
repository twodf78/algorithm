def solution(n, lost, reserve):
    answer = n - len(lost)
    lost.sort()
    reserve.sort()
    
    reserveDict = {}
    for r in reserve:
        if r not in lost:
            reserveDict[r] = 1
        else:
            answer+=1
    for l in lost:
        if l in reserve:
            continue
        if l - 1 in reserveDict and reserveDict[l-1] > 0:
            reserveDict[l-1] -=1
            answer+=1
        elif l + 1 in reserveDict and reserveDict[l+1] > 0:
            reserveDict[l+1] -=1
            answer+=1
    
    return answer