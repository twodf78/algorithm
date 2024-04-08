map = {}
map["{"] = 1
map["}"] = -1
map["["] = 2
map["]"] = -2
map["("] = 3
map[")"] = -3


def isValid(list):
    stack = []
    for el in list:
        if map.get(el) > 0:
            stack.append(el);
        else:
            if len(stack) == 0:
                return False
            else:
                last = stack.pop();
                if map.get(last) + map.get(el) != 0:
                    return False
    return len(stack) == 0

def solution(s):
    answer = 0

    sList = list(s);
    for i in range(len(sList)):
        temp = sList[0];
        sList = sList[1:];
        sList.append(temp);
        if isValid(sList):
            answer+=1;

    return answer