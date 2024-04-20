def solution(s):
    answer = True
    pCnt = 0
    yCnt = 0
    for letter in list(s):
        if letter.lower() == "p":
            pCnt+=1
        elif letter.lower() == "y":
            yCnt+=1

    return pCnt == yCnt