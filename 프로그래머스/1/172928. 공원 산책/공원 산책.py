dr = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
]
def solution(park, routes):
    h = len(park)
    w = len(park[0])
    p = None
    for i in range(h):
        row = park[i]
        for idx, road in enumerate(list(row)):
            if road == "S":
                p = [i, idx]
                break

    def isValid(num, direction):
        height = p[0] + direction[0] * num 
        width = p[1] + direction[1] * num 
        if height >= h or height < 0 or width >= w or width < 0:
            return False
        for n in range(1, num + 1):
            if park[p[0] + direction[0] * n][p[1] + direction[1] * n] == "X":
                return False
        return True
    for route in routes:
        [op, num] = route.split(" ")
        num = int(num)
        if op == "E":
            if isValid(num, dr[0]):
                p = [p[0], p[1] + num]
        elif op == "W":
            if isValid(num, dr[1]):
                p = [p[0], p[1] - num]
        elif op == "S":
            if isValid(num, dr[2]):
                p = [p[0] + num, p[1]]
        elif op == "N":
            if isValid(num, dr[3]):
                p = [p[0] - num, p[1]]
            
    return p