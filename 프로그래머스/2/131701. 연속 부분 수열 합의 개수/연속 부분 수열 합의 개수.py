def solution(elements):
    current = list(elements)
    answer = set()
    for j in range(len(elements)):
        answer.add(current[j])
        for i in range(1, len(elements)):
            idx = (i + j) % len(elements)
            current[j] += elements[idx]
            answer.add(current[j])
    return len(answer)