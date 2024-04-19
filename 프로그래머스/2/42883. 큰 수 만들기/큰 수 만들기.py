def solution(number, k):
    stack = []

    for num in list(map(int,list(number))):
        while(len(stack) > 0 and stack[-1] < num and k > 0):
            k-=1
            stack.pop()
        stack.append(num)

    stack = "".join(list(map(str,list(stack))))
    return stack[:-k] if k > 0 else stack