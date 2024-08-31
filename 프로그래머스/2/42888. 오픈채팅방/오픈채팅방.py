def solution(record):
    answer = []
    idMatchName = {}
    for command in record:
        splitArr= command.split(" ")
        action = splitArr[0] 
        userId = splitArr[1] 
        if action == 'Enter' :
            nickName = splitArr[2]
            idMatchName[userId] = nickName
            answer.append(userId + '/님이 들어왔습니다.')
        elif action == 'Leave':
            answer.append(userId + '/님이 나갔습니다.')
        elif action == 'Change':
            nickName = splitArr[2]
            idMatchName[userId] = nickName
    return list(map(lambda x: idMatchName[x.split("/")[0]] + x.split("/")[1], answer))

