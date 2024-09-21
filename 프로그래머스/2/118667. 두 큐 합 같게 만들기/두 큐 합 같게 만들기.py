def solution(queue1, queue2):
    total_arr = queue1 + queue2  # 두 큐를 하나로 합친 배열
    max_count = 4 * len(total_arr)  # 최대 반복 횟수 설정
    target_val = sum(total_arr) / 2  # 목표 값: 전체 배열의 합을 반으로 나눈 값
    total_length = len(total_arr)  # 배열의 길이 저장

    count = 0
    start, end = 0, len(queue1)
    total_sum = sum(total_arr[start:end])  # 처음에는 queue1의 합으로 시작

    while count <= max_count:
        if target_val > total_sum:
            if end >= total_length:  # end가 배열 길이를 초과하지 않도록 조건 추가
                break
            total_sum += total_arr[end]
            end += 1
        elif target_val < total_sum:
            total_sum -= total_arr[start]
            start += 1
        else:  # 합이 목표 값과 같으면 count 반환
            return count
        count += 1

    return -1  # 목표 값을 맞출 수 없으면 -1 반환
