def solution(arr):
    answer = [0,0]
    checkFlag = True
    n = len(arr)
    def checkAndFill(xStart, xEnd, yStart,yEnd):
        standard = arr[yStart][xStart]
        if standard == 2:
            return True;
        for i in range(yStart, yEnd) :
            for j in range(xStart, xEnd) :
                if arr[i][j]!= standard:
                    return False;
        answer[standard] += 1;
        for i in range(yStart, yEnd) :
            for j in range(xStart, xEnd) :
                arr[i][j] = 2;
        return True
    i = n
    while(i >=1):
        checkFlag = True
        for yStart in range(0, n, i):
            for xStart in range(0, n, i):
                checkFlag &= checkAndFill(xStart, xStart+i, yStart, yStart+i)
        if checkFlag:
            break
        i=int(i/2)
    return answer

