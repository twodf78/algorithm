def solution(skill, skill_trees):
    answer = 0
    skillMap = {}
    idx = 1
    for s in list(skill):
        skillMap[s] = idx
        idx+=1
    for tree in skill_trees:
        idx = 1
        flag = True
        for s in list(tree):
            if s not in skillMap:
                continue
            else:
                if skillMap[s] != idx:
                    flag = False
                else:
                    idx+=1
        if(flag):
            answer+=1
                
                    
    return answer