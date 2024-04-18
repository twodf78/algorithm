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
    
    # startPoint 찾기
    for i in range(h):
        row = park[i]
        for idx, road in enumerate(list(row)):
            if road == "S":
                p = [i, idx]
                break
        if p != None:
            break

    # 무시조건 확인
    def isValid(num, direction):
        height = p[0] + direction[0] * num 
        width = p[1] + direction[1] * num 
        if height >= h or height < 0 or width >= w or width < 0:
            return False
        for n in range(1, num + 1):
            if park[p[0] + direction[0] * n][p[1] + direction[1] * n] == "X":
                return False
        return True
    
    # 루트 한 발짝씩 나아가기
    for route in routes:
        [op, num] = route.split(" ")
        num = int(num)
        idx = -1
        if op == "E":
            idx = 0
        elif op == "W":            
            idx = 1
        elif op == "S":
            idx = 2
        elif op == "N":
            idx = 3
        
        if idx != -1 and isValid(num, dr[idx]):
            p = [p[0] + dr[idx][0] * num, p[1] + dr[idx][1] * num]
            
    return p