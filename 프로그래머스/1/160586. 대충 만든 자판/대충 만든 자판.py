def solution(keymap, targets):
    answer = []
    map = {}
    for key in keymap:
        for idx, letter in enumerate(list(key)):
            current = map.get(letter);
            if current != None:
                map[letter] = current if current <= idx + 1 else idx + 1
            else: 
                map[letter] = idx + 1
    
    for target in targets:
        acc = 0
        flag= True
        for letter in list(target):
            current = map.get(letter);
            if current == None:
                answer.append(-1)
                flag = False
                break
            else: 
                acc += current
        if flag == True:
            answer.append(acc)
               
    return answer