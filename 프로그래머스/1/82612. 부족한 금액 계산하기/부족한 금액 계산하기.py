def solution(price, money, count):
    answer = -1
    acc = 0
    for i in range(1, count+ 1):
        acc += i * price
    return 0 if money >= acc else acc - money