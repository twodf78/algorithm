from functools import reduce
def solution(clothes):
    clothMap = {}
    for [_, type] in clothes:
        clothMap[type] = clothMap.get(type) + 1 if type in clothMap else  1
    return reduce(lambda x,y: (x) * (y + 1) , clothMap.values(), 1) - 1 