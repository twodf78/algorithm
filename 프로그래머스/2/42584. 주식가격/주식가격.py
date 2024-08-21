def solution(prices):
    answer = [0 for _ in range(len(prices))]
    stack = []
    for idx in range(len(prices)):
        price= prices[idx]
        count = 0
        while len(stack) > 0 and stack[-1]["price"] > price:
            last = stack.pop()
            answer[last["idx"]] = idx - last["idx"] 
        stack.append({"idx": idx, "price": price})
    while len(stack) > 0:
        last = stack.pop()
        answer[last["idx"]] = len(prices) - last["idx"] - 1
    
    return answer