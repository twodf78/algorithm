def dateChanger(date):
    tY, tM, tD = map(int,date.split("."))
    return tY * 12 * 28 + tM * 28 + tD
    
def solution(today, terms, privacies):
    todayTotal = dateChanger(today)
    def isPassed(target, passed):
        targetTotal = dateChanger(target) + passed * 28
        return todayTotal >= targetTotal
    
    answer = []
    valid = {}
    for term in terms:
        alphaType, month = term.split(" ")
        valid[alphaType] = int(month)
        
    for idx, privacy in enumerate(privacies):
        start, alphaType = privacy.split(" ")
        if isPassed(start, valid.get(alphaType)):
            answer.append(idx + 1)
        
    return answer