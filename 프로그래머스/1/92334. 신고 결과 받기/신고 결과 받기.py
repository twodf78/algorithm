def solution(id_list, report, k):
    answer = []
    dic = {}
    reporter = {}
    
    for list in report:
        source, target = list.split(" ")
        if target in dic:
            dic[target].add(source)
        else:
            dic[target] = set()    
            dic[target].add(source)
        
        if source in reporter:
            reporter[source].add(target)
        else:
            reporter[source] = set()    
            reporter[source].add(target)
            
    for id in id_list:
        if id not in reporter:
            answer.append(0)
            continue
        acc = 0
        for target in reporter.get(id):
            if target in dic and len(dic.get(target)) >= k:
                acc+=1
        answer.append(acc)
        
    return answer 