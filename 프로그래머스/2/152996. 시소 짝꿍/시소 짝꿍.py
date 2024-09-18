def compare(small, big):
    if small == big or small * 2 == big or small * 3 == big * 2 or small * 4 == big * 3:
        return True
    return False

def factorial(num):
    ans = 0
    for i in range(num, 0, -1):
        ans += i
    return ans

def solution(weights):
    answer = 0
    weight_dict = {}

    weights.sort()

    for weight in weights:
        if weight not in weight_dict:
            weight_dict[weight] = 1
        else:
            weight_dict[weight] += 1

    weight_arr = list(weight_dict.keys())

    for i in range(len(weight_arr)):
        current_weight = weight_arr[i]
        current_count = 0

        for j in range(i + 1, len(weight_arr)):
            target_weight = weight_arr[j]

            if target_weight > current_weight * 2:
                break

            if compare(current_weight, target_weight):
                current_count += weight_dict[target_weight]

        answer += (current_count * weight_dict[current_weight]) + factorial(weight_dict[current_weight] - 1)

    return answer
