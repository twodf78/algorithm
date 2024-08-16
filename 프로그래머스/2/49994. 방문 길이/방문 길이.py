def move(now, dir):
    if dir == "U":
        return [now[0], now[1]+1]
    elif dir == "D":
        return [now[0], now[1]-1]
    elif dir == "L":
        return [now[0]-1, now[1]]
    elif dir == "R":
        return [now[0]+1, now[1]]
        
def solution(dirs):
    visitMap = {}
    count = 0
    now = [0,0]
    for dir in list(dirs):
        moved = move(now, dir)
        if(moved[0] < -5 or moved[0] > 5 or moved[1] < -5 or moved[1] > 5):
            continue
        key1 = generateKey(now, moved)
        key2 = generateKey(moved, now)
        now = moved
        
        if key1 in visitMap:
            continue
        
        visitMap[key1] = True
        visitMap[key2] = True
        count+=1
    return count

def generateKey(now, moved):
    return "from:" + str(now[0]) + ","+str(now[1]) + "to:"+ str(moved[0]) + ","+str(moved[1])