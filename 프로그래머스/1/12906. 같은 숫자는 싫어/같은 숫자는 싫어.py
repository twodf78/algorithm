def solution(arr):
    previous = arr[0]
    answer = [previous]
    for i in range(1, len(arr)):
        current = arr[i]
        if current != previous:
            answer.append(current)
        previous = current

    return answer