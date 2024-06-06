def solution(name, yearning, photo):
    answer = []
    memory = {}
    for idx in range(len(name)):
        memory[name[idx]] = yearning[idx]
    for item in photo:
        point = 0
        for person in item:
            point += memory.get(person) if person in memory else 0
        answer.append(point)
    return answer