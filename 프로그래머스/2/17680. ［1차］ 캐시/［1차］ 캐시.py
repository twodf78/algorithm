def solution(cacheSize, cities):
    answer = 0
    cache = [0 for _ in range(cacheSize)]
    cacheDict = {}
    for i in range(len(cities)):
        city = cities[i].lower()
        if city in cache:
            idx = cache.index(city)
            answer+=1
            cache.pop(idx)
        else:
            answer+=5
            if len(cache) > 0:
                cache.pop(0)
        cache.append(city)
    return len(cities) * 5 if cacheSize == 0 else answer

