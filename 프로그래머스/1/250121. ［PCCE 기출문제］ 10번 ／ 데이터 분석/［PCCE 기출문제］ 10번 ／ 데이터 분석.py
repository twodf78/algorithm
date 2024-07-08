def converter(word):
    if word == "code":
        return 0 
    if word == "date":
        return 1
    if word == "maximum":
        return 2
    if word == "remain":
        return 3
def solution(data, ext, val_ext, sort_by):
    answer = list(filter(lambda x: x[converter(ext)] <= int(val_ext), data))
    answer.sort(key=lambda x: x[converter(sort_by)]) 
    return answer