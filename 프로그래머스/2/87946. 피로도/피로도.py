def solution(k, dungeons):
    answer = -1
    def dfs(visit, remain):
        res = 1
        for i in range(len(dungeons)):
            if visit[i] :
                continue
            if remain >= dungeons[i][0]:
                newVisit = list(visit)
                newVisit[i] = True
                currentCount = dfs(newVisit, remain - dungeons[i][1]) + 1
                res = currentCount if currentCount > res else res
        return res
    maxCount = 0
    for i in range(len(dungeons)):
        visit = [False for i in range(len(dungeons))]
        visit[i] = True
        count = dfs(visit, k - dungeons[i][1]);
        maxCount = maxCount if maxCount > count else count
    return maxCount

