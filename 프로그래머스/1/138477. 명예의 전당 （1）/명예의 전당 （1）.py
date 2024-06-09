from queue import PriorityQueue
def solution(k, score):
    answer = []
    hall = PriorityQueue()
    minVal = score[0]
    for s in score:
        if  hall.qsize() < k:
            hall.put(s)
            minVal = min(minVal, s)
            answer.append(minVal)
        else:
            minVal = hall.get()
            bigger = max(minVal, s)
            hall.put(bigger)
            minVal = hall.get()
            hall.put(minVal)
            answer.append(minVal)
            
            
    return answer