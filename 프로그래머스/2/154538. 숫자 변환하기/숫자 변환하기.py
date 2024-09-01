def solution(x, y, n):
    answer = -1
    stack = [{"num": y, "tried":0}]
    while len(stack) > 0:
        val = stack.pop(0);
        num = val["num"]
        tried = val["tried"]
        if num == x:
            answer = tried
            break
        if num % 2 == 0:
            stack.append({"num":num/2, "tried":tried+1})
        if num % 3 == 0:
            stack.append({"num":num/3, "tried":tried+1})
        if num - n >= x:
            stack.append({"num":num-n, "tried":tried+1})
    return answer

