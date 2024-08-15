def solution(topping):
    answer = 0
    typeNum = len(set(topping))
    
    toppingDict = {}
    for val in topping:
        if val in toppingDict:
            toppingDict[val] +=1
        else:
            toppingDict[val] = 1
    
    brotherDict = set()
    for val in topping:
        if val not in brotherDict:
            brotherDict.add(val)
        toppingDict[val] -= 1
        if toppingDict[val] == 0:
            typeNum -= 1
        if len(brotherDict) == typeNum:
            answer+=1
    return answer