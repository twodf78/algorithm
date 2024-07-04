def solution(X, Y):
    answer = []
    dictX = {}
    for x in list(X):
        if x in dictX:
            dictX[x] += 1
        else:
            dictX[x] = 1
    
    for y in list(Y):
        if y in dictX and dictX[y] > 0:
            dictX[y] -= 1
            answer.append(y)
        
            
    if len(answer) == 0:
        return "-1"
    answer.sort()
    answer.reverse()
    if len(list(filter(lambda x: x!= "0", answer))) == 0:
        return "0"
    return "".join(answer)