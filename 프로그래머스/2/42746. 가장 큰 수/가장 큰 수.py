from functools import cmp_to_key
def compare(a, b):
    a1 = int(a + b)
    b1 = int(b + a)
    return b1 - a1


def solution(numbers):
    answer = ''
    strNum = list(map(lambda v:str(v), numbers))
    strNum.sort(key=cmp_to_key(compare))
    return str(int("".join(strNum)))
