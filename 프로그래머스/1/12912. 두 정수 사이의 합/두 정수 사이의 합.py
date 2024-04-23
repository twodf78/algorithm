from functools import reduce
import math
def solution(a, b):
    return reduce(lambda acc, el: acc + el, list(range(min(a,b), max(a,b)+1)))