from functools import reduce
def solution(numbers):
    answer = reduce(lambda acc, el: acc + el, list(range(10)))
    answer = reduce(lambda acc, el: acc - el, numbers, answer)
    return answer