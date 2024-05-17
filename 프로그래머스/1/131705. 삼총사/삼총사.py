def solution(number):
    answer = 0
    length = len(number)
    
    for i in range(length):
        for j in range(i + 1, length):
            for z in range(j + 1, length):
                if number[i] + number[j] + number[z] == 0:
                    answer+=1
    return answer
