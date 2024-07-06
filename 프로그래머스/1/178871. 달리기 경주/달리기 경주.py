def solution(players, callings):
    answer = []
    grade = {}
    for i, player in enumerate(players):
        grade[player] = i
    
    for call in callings:
        current = grade[call]
        temp = players[current - 1]
        players[current - 1] = players[current]
        players[current] = temp
        
        grade[call] -= 1
        grade[temp] += 1
    return players