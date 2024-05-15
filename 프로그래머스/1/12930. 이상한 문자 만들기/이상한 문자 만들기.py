def solution(s):
    answer = []
    strList = s.split(" ")
    for str in strList:
        temp = ""
        for i in range(len(str)):
            if i % 2 == 0:
                temp += str[i].upper()
            else:
                temp += str[i].lower()
        answer.append(temp)
        
    return " ".join(answer)