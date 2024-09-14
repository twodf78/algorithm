import itertools
def solution(n):
    answer = []
    row = -1
    col = 0
    fill = 0
    
    for i in range(n):
        answer.append([0 for _ in range(i+1)])
    
    i = n
    while i>0:
        for j in range(i):
            answer[row][col] = fill
            fill+=1
            row+=1
        for j in range(i-1):
            answer[row][col] = fill
            fill+=1
            col+=1
        for j in range(i-2):
            answer[row][col] = fill
            fill+=1
            row-=1
            col-=1
        i-=3
    answer[row][col] = fill
    
    return list(itertools.chain(*answer))


