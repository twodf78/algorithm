from functools import reduce
def solution(land):
    return max(reduce(lambda a, c : 
         [
            c[0] + max(a[1], a[2], a[3]),  
            c[1] + max(a[0], a[2], a[3]),
            c[2] + max(a[0], a[1], a[3]),
            c[3] + max(a[0], a[1], a[2]),
        ],  land, [0, 0, 0, 0]))

