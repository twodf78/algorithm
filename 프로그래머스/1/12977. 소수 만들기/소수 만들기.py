prime = [True for _ in range(3001)]
for i in range(2, 3001):
    if not prime[i] :
        continue
    for j in range(i + i, 3001, i):
        prime[j] = False

def solution(nums):
    answer = 0
    for i in range(len(nums)):
        for j in range(i+1, len(nums)):
            for k in range(j +1, len(nums)):
                idx = nums[i] + nums[j] + nums[k]
                if prime[idx]:
                    answer+=1
    return answer

