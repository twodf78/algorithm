def solution(citations):
    citations.sort()
    min =0
    max = citations[-1]
    while min<= max:
        mid = (min+max)//2
        h= len(list(filter(lambda v : v>=mid , citations)))
        rest = len(citations) - h
        if h>=mid and rest <= mid:
            min = mid + 1
        else:
            max = mid - 1
    return max
