def solution(order):
    answer = 0
    stack = []
    sequence = 0

    
    i = 1
    while i<=len(order) and sequence < len(order):
        current = order[sequence]
        if i == current:
            answer+=1
            sequence+=1
            i+=1
        else:
            if len(stack)>0 and stack[-1] == current:
                stack.pop()
                answer+=1
                sequence+=1
            else:
                stack.append(i)
                i+=1
    while len(stack) > 0:
        current = order[sequence]
        if stack[-1] != current:
            break
        stack.pop()
        answer+=1
        sequence+=1
    
    return answer