def solution(numbers):
    result = []
    
    for num in numbers:
        current = bin(num)[2:]  # 숫자를 이진수 문자열로 변환
        current_arr = list(current)  # 이진수를 리스트로 변환
        last_zero_idx = ''.join(current_arr).rfind('0')  # 마지막 '0'의 인덱스 찾기

        if last_zero_idx < 0:  # '0'이 없을 경우
            result.append(num + 2 ** (len(current) - 1))
        else:
            last_one_idx = ''.join(current_arr).rfind('1')  # 마지막 '1'의 인덱스 찾기
            add = len(current_arr) - 1
            if last_one_idx < last_zero_idx:
                add -= last_zero_idx
            else:
                add -= (last_zero_idx + 1)
            
            result.append(num + 2 ** add)
    
    return result
