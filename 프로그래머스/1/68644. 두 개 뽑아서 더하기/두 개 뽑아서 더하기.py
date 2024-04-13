def solution(numbers):
    ans = set()
    numbers.sort()
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            ans.add(numbers[i] + numbers[j])
    ans = list(ans)
    ans.sort()
    return ans