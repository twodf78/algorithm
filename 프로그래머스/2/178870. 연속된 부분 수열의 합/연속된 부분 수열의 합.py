def solution(sequence, k):
    answer = []
    left = 0
    right = 0
    sumVal = sequence[right]
    while right < len(sequence):
        if sumVal < k:
            right+=1
            if right >= len(sequence):
                break
            sumVal += sequence[right]
        elif sumVal > k:
            sumVal -= sequence[left]
            left+=1
        else:
            answer.append([left, right])
            right+=1
            
            if right >= len(sequence):
                break
            sumVal += sequence[right]
    answer.sort(key=lambda a: (a[1] - a[0], a[0]))

    
    return answer[0]

