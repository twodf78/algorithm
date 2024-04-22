from functools import reduce
def solution(x):
    return x % (reduce(lambda acc, x: acc+ int(x), list(str(x)), 0)) == 0