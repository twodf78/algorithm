def solution(arr1, arr2):
    h, w = len(arr1),len(arr1[0]) 
    answer = []
    for i in range(h):
        answer.append([])
        for j in range(w):
            answer[i].append(arr1[i][j] + arr2[i][j])
    return answer