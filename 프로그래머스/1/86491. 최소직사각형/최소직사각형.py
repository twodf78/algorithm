def solution(sizes):
    maxBig = 0
    maxSmall = 0
    for [h, w] in sizes:
        big = h if h>w else w
        small = w if h>w else h
        
        maxBig = big if big > maxBig else maxBig
        maxSmall = small if small > maxSmall else maxSmall
    return maxBig * maxSmall