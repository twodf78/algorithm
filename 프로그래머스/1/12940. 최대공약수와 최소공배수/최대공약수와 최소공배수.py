def solution(n, m):
    minNum = n if n< m else m
    maxNum = m if n< m else n
    answer = []
    
#     최대공약수
    for i in range(minNum, 0, -1):
        if minNum % i == 0 and maxNum % i == 0:
            answer.append(i)
            break
            
#     최소공배수

    i = 0
    while True:
        i+=maxNum
        if i % minNum == 0:
            answer.append(i)
            break
            
    return answer