dict = {}
dict["aya"] = 1
dict["ye"] = 2
dict["woo"] = 3
dict["ma"] = 4
def solution(babbling):
    answer = 0
    
    for babble in babbling:
        word = ""
        previous = 0
        flag = True
        for letter in list(babble):
            word += letter
            if word in dict:
                if previous != dict[word]:
                    flag = True
                    previous = dict[word]
                    word = ""
            else:
                flag = False
        if flag:
            answer+=1
    return answer