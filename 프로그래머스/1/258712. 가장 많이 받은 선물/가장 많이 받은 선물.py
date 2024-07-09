def solution(friends, gifts):
    answer = 0
    nameDict = {}
    for i, friend in enumerate(friends):
        nameDict[friend] = i + 1
    
    giftMap = [[0 for _ in range(len(friends) + 1)] for _ in range(len(friends) + 1)]
    
    for gift in gifts:
        [giver, receiver] = map(lambda x: nameDict[x], gift.split(" "))
        giftMap[giver][receiver] +=1
        giftMap[giver][0] += 1
        giftMap[0][receiver] += 1
    
    answer = []
    for giver in range(1, len(friends) + 1):
        count = 0
        for receiver in range(1, len(friends) + 1):
            if giver == receiver:
                continue
            given = giftMap[giver][receiver]
            received = giftMap[receiver][giver]
            
            if given > received:
                count+=1
            elif given == received:
                numOfGiver = giftMap[giver][0] - giftMap[0][giver]
                numOfReceiver = giftMap[receiver][0] - giftMap[0][receiver]
                if numOfGiver > numOfReceiver:
                    count += 1
        answer.append(count)
        
    answer.sort()
    return answer[len(answer) - 1]