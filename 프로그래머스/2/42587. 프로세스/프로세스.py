def solution(priorities, location):
    target = priorities[location]
    answer = 0
    idx = 0
    
    maxList = list(set(priorities))
    maxList.sort()
    maxList.reverse()
    
    count = 0
    maxVal = maxList[count]
    
    while count < 10:
        if maxVal == target:
            newIdx = idx
            for i in range(len(priorities)):
                if newIdx >= len(priorities):
                    newIdx = 0
                if priorities[newIdx] == maxVal:
                    if newIdx == location:
                        return answer+1
                    answer+=1
                newIdx+=1
        newIdx = idx
        for i in range(len(priorities)):
            if newIdx >= len(priorities):
                newIdx = 0
            if priorities[newIdx] == maxVal:
                idx = newIdx
                answer+=1
            newIdx+=1
        count+=1
        maxVal = maxList[count]
