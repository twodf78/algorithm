def solution(array, commands):
    answer = []
    for [sIdx, lIdx, idx] in commands:
        newArr = array[sIdx - 1 : lIdx]
        newArr.sort()
        answer.append(newArr[idx -1])
    return answer