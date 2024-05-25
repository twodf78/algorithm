def solution(n):
    answer = 0
    strList = list(str(n))
    for s in strList:
        answer+= int(s)
    return answer