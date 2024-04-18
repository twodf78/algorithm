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
    
    # 시작지점 찾기
    for rowIdx in range(h):
        row = park[rowIdx]
        for columnIdx, area in enumerate(list(row)):
            if area == "S":
                p = [rowIdx, columnIdx]
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
    
    # 명령 하나씩 수행하기
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
        
        # 방어코딩 + 문제 조건의 만족할 시, 해당 명령을 수행
        if idx != -1 and isValid(num, dr[idx]):
            p = [p[0] + dr[idx][0] * num, 
                 p[1] + dr[idx][1] * num]
            
    return p