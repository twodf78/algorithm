def solution(arr, divisor):
    arr.sort()
    answer = list(filter(lambda x: x % divisor== 0, arr))
    return [-1] if len(answer) == 0 else answer