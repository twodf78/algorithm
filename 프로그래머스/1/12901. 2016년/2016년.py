
weekday = ['THU', 'FRI','SAT', 'SUN','MON','TUE','WED'];
days = [31,29,31,30,31,30,31,31,30,31,30,31];
def solution(a, b):
    day = b
    for i in range(1, a):
        day += days[i - 1]
    return weekday[day%7]
