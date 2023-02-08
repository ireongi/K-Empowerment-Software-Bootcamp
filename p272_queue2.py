def queue_is_full():
    global SIZE, queue, rear, front
    if (rear + 1) % SIZE == front:
        return True
    return False


def queue_is_empty():
    global SIZE, queue, rear, front
    if front == rear:
        return True
    return False


def en_queue(data):
    global SIZE, queue, rear, front, time
    if queue_is_full():
        print("Queue is FULL!")
        return
    else:
        rear = (rear + 1) % SIZE
        queue[rear] = data
        time += data[1]
    return data


def de_queue():
    global SIZE, queue, rear, front
    if queue_is_empty():
        print("Queue is EMPTY~")
        return
    front = (front + 1) % SIZE
    data = queue[front]
    queue[front] = None
    return data


SIZE = 6
queue = [None for _ in range(SIZE)]
rear = front = 0
time = 0

if __name__ == "__main__":
    wait_call = [('사용', 9), ('고장', 3), ('환불', 4), ('환불', 4), ('고장', 3)]

    print(f'귀하의 대기 예상시간은 {time}분입니다.')
    print(f'현재 대기 콜 : {queue}')
    print()

    for i in range(0, SIZE-1, 1):
        en_queue(wait_call[i])
        if not queue_is_full():
            print(f'귀하의 대기 예상시간은 {time}분입니다.')
            print(f'현재 대기 콜 : {queue}')
            print()
    print(f'최종 대기 콜 : {queue}')
    print('프로그램 종료!')
