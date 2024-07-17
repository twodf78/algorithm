def solution(s):
    arrS = list(s)
    stack = []
    for i in range(len(arrS) - 1, -1, -1):
        if len(stack) > 0 and arrS[i] == stack[-1]:
            stack.pop()
        else:
            stack.append(arrS[i])
    return 1 if len(stack) == 0 else 0
