from math import sqrt
def division(num):
    ret = 2
    sqrtNum = int(sqrt(num))
    for i in range(2, int(sqrtNum) + 1):
        if num % i == 0:
            ret+=2
    return ret - 1 if sqrtNum * sqrtNum == num else ret

def solution(number, limit, power):
    answer = 0
    for i in range(2, number + 1):
        div = division(i)
        if div > limit:
            answer += power
        else:
            answer += div
    return answer + 1