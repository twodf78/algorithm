def grade(match):
    if 7 - match > 6:
        return 6
    elif 7 - match < 1:
        return 1
    return 7 - match
def solution(lottos, win_nums):
    answer = []
    win = {}
    for nums in win_nums:
        win[nums] = 1
    match = 0
    zero = 0
    for lotto in lottos:
        if lotto in win_nums:
            match+=1
        elif lotto == 0:
            zero += 1
    return [grade(match+zero) , grade(match)]