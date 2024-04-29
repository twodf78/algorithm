def solution(elements):
    current = list(elements)
    answer = set(current)
    for i in range(1, len(elements)):
        for j in range(len(elements)):
            idx = (i + j) % len(elements)
            current[j] += elements[idx]
            answer.add(current[j])
    return len(answer)