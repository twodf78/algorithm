from functools import reduce
def solution(dartResult):
    answer = []
    currentIdx = -1
    previousIsNum = False
    for dart in list(dartResult):
        if dart == "S":
            answer[currentIdx]**= 1
        elif dart == "D":
            answer[currentIdx]**= 2
        elif dart == "T":
            answer[currentIdx]**= 3
        elif dart == "*":
            answer[currentIdx]*= 2
            if currentIdx >= 1:
                answer[currentIdx - 1]*= 2
        elif dart == "#":
            answer[currentIdx]*= -1
        else:
            currentIdx+=1
            answer.append(int(dart))
            if previousIsNum:
                currentIdx-=1
                answer.pop()
                answer.pop()
                answer.append(10)
            previousIsNum = True
            continue
        previousIsNum = False
            
    return reduce(lambda acc, x: acc + x, answer)