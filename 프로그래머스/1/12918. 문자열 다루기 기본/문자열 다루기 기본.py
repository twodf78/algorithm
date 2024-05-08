def solution(s):
    strList = list(s)
    if len(strList) != 4 and len(strList) != 6:
        return False
    
    for word in strList:
        if not word.isdigit():
            return False
    
    return True