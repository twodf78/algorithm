def return_map(lst, add_time):
    return [{'time': v['time'] + add_time, 'w': v['w']} for v in lst]

def solution(bridge_length, bridge_weight, truck_weights):
    on_bridge = []
    on_weight = 0
    second = 0

    def on_to_bridge(current_weight):
        nonlocal on_weight, second, on_bridge
        on_bridge.append({'time': 0, 'w': current_weight})
        on_weight += current_weight
        second += 1
        on_bridge = return_map(on_bridge, 1)

    def down_from_bridge():
        nonlocal on_weight, on_bridge
        while on_bridge and on_bridge[0]['time'] >= bridge_length:
            down = on_bridge.pop(0)
            on_weight -= down['w']

    def wait_for_down():
        nonlocal second, on_bridge
        wait = bridge_length - on_bridge[0]['time']
        on_bridge = return_map(on_bridge, wait)
        down_from_bridge()
        second += wait

    for w in truck_weights:
        if w + on_weight <= bridge_weight:
            on_to_bridge(w)
        else:
            if on_bridge[0]['time'] > bridge_length:
                down_from_bridge()
            else:
                wait_for_down()
            while w + on_weight > bridge_weight:
                wait_for_down()
            on_to_bridge(w)

    while on_bridge:
        wait_for_down()

    return second + 1
