def solution(k, tangerine):
    dict = {}
    for t in tangerine:
        if t in dict:
            dict[t] += 1
        else:
            dict[t] = 1
            
    l = list(dict.items())
    l.sort(key = lambda x: x[1])
    answer = len(l)
    dif = len(tangerine) - k
    for [_, cnt] in l:
        if dif < cnt:
            break
        dif -= cnt
        answer -= 1
        
    return answer