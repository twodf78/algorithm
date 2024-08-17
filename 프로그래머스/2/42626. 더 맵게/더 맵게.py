from collections import deque
def solution(scoville, K):
    answer = 0 
    mix = deque()
    scoville.sort()
    sco = deque(i for i in scoville)
    while (sco and sco[0] < K) or (mix and mix[0] < K):
        answer += 1
        if len(sco) + len(mix) <= 1:
            return -1
        
        food = [0]*2
        for idx in range(2):
            if sco and mix:
                if sco[0] < mix[0]:
                    food[idx] = sco.popleft()
                else:
                    food[idx] = mix.popleft()
            elif sco:
                food[idx] = sco.popleft()
            else:
                food[idx] = mix.popleft()
            
        mix.append(food[0]+food[1]*2)
        
    return answer

