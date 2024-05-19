bigAlpha = [chr(i) for i in range(ord("A"), ord("Z") + 1)]
smallAlpha = [chr(i) for i in range(ord("a"), ord("z") + 1)]
def solution(s, n):
    answer = ''
    strList = list(s)
    for str in strList:
        if str == " ":
            answer += str
        else:
            asciiNum = ord(str)
            if asciiNum <= 90:
                idx = (bigAlpha.index(str) + n) % len(bigAlpha)
                answer +=   bigAlpha[idx]
            else:
                idx = (smallAlpha.index(str) + n) % len(smallAlpha)
                answer +=   smallAlpha[idx]
                
    return answer