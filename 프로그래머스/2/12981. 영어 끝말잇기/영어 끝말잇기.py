def solution(n, words):
    answer = []
    count = 1
    dict = {}
    for i in range(len(words)):
        word = words[i]
        if word not in dict:
            dict[word] = 1
        else:
            answer.append(n if (i+1)%n==0 else (i+1)%n)
            answer.append(count)
            break
        if i>0:
            previousLastLetter = words[i-1][-1];
            currentFirstLetter = word[0];
            if previousLastLetter!= currentFirstLetter:
                answer.append(n if (i+1)%n==0 else (i+1)%n)
                answer.append(count)
                break
        if (i+1)%n==0:
            count+=1
        
    return [0,0] if len(answer) == 0 else answer


