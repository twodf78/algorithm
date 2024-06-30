def solution(participant, completion):
    answer = ''
    dic = {}
    for par in participant:
        if par in dic:
            dic[par]+=1
        else:
            dic[par] = 1
    for complete in completion:
        dic[complete] -=1
    itemList = list(dic.items())
    return list(filter(lambda x:x[1] == 1, itemList))[0][0]