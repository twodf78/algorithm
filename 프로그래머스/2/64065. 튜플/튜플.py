def solution(s):
    answer = []
    arrS = list(map(lambda lst: lst.split(","), s[2:-2].split("},{")))
    arrS.sort(key=lambda lst: len(lst)) 
    answer.append(arrS[0][0])
    for i in range(1, len(arrS)):
        currentSet = arrS[i]
        for j in range(len(currentSet)):
            if currentSet[j] in answer:
                continue
            answer.append(currentSet[j])
            break
            
    return list(map(lambda x: int(x),answer))

