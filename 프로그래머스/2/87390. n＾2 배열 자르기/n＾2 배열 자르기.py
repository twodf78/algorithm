def solution(n, left, right):
    return  [i%n + 1 if i//n + 1 <  i%n + 1 else i//n + 1 for i in range(left, right+1)]
    