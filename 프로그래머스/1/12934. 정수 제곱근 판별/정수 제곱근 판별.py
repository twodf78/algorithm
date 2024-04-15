import math
def solution(n):
    if math.sqrt(n) == math.floor(math.sqrt(n)):
        return math.pow(math.sqrt(n) + 1, 2)
    else:
        return -1
