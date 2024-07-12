def solution(s):
    count = 0
    zeroCount = 0
    while s != '1':
        count+=1
        onlyOne = list(filter(lambda x: x!= '0',list(s)))
        zeroCount+=len(s) - len(onlyOne)
        s = bin(len(onlyOne))[2:]
    return [count, zeroCount]