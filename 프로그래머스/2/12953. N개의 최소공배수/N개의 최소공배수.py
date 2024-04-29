from functools import reduce
def isValid(numList, num):
    for el in numList:
        if num % el != 0:
            return False
    return True
def solution(arr):
    arr.sort()
    maxNum = reduce(lambda acc, x: acc * x, arr, 1)
    for num in range(arr[-1], maxNum, arr[-1]):
        if isValid(arr, num):
            return num
    return maxNum