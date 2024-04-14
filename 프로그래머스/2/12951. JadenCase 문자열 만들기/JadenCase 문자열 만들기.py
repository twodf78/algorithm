def solution(s):
    answer = ''
    isBlank = True
    for word in list(s):
        if word == " ":
            isBlank = True
            answer+=word
        else:
            if isBlank == True:
                answer+=word.upper()
                isBlank = False
            else:
                answer+=word.lower()
                isBlank = False
    return answer