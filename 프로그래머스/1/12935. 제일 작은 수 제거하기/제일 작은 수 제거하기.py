def solution(arr):
    minVal = min(arr)
    arr = list(filter(lambda x: x!= minVal, arr))
    return [-1] if len(arr) == 0 else arr