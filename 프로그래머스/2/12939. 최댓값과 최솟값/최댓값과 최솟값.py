def solution(s):
    answer = list(map(int, s.split(" ")))
    answer.sort()
    answer = list(map(str, answer))
    return answer[0] + " " + answer.pop()