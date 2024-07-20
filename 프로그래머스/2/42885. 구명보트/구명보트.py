def solution(people, limit):
    answer = 0
    people.sort()
    small = 0
    big = len(people) - 1
    while small <= big:
        if limit < people[big] + people[small]:
            big-=1
            answer+=1
        else:
            big-=1
            small+=1
            answer+=1
    return answer