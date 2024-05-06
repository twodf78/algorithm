from math import ceil
def isOddDiv(num):
    count = 0
    for i in range(1, num + 1):
        if num % i == 0:
            count+=1
            
    return count % 2 != 0
            
def solution(left, right):
    answer = 0
    for num in range(left, right + 1):
        if isOddDiv(num):
            answer -= num
        else:
            answer += num
    return answer