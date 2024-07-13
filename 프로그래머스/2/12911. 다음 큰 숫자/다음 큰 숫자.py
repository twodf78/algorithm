def solution(n):
    answer= n 
    oneCount = len(list(filter(lambda x: x=='1', list(bin(n)[2:]))))
    while(True):
        answer +=1
        binary = bin(answer)[2:]
        if len(list(filter(lambda x: x=='1', list(binary)))) == oneCount:
            return answer
