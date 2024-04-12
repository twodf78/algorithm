def solution(numbers):
    answer, stack = [], []
    numbers.reverse()
    for num in numbers:
        while len(stack) > 0 and stack[-1] <= num:
            stack.pop()
        
        if len(stack) == 0:
            answer.append(-1)
        else: 
            answer.append(stack[-1])
        stack.append(num)

    answer.reverse()
    return answer