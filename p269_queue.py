def is_queue_full():
    global SIZE, queue, front, rear
    if rear == SIZE-1:
        return True
    elif rear != SIZE-1 and front == -1:
        return False


def is_queue_empty():
    global SIZE, queue, front, rear
    if rear ==  front:
        print('식당 영업 종료!')
        return True
    return False


def en_queue(data):
    global SIZE, queue, front, rear
    if is_queue_full():
        print("Queue is Full!")
        return
    rear = (rear + 1) % SIZE
    queue[rear] = data


def de_queue():
    global SIZE, queue, front, rear
    if is_queue_empty():
        print("Queue is EMPTY~")
        return None
    front = (front + 1) % SIZE
    data = queue[front]
    queue[front] = None
    for i in range(front+1, SIZE, 1):
        queue[i-1] = queue[i]
        queue[i] = None
    front -= 1
    rear -= 1
    return data


SIZE = 6
front = rear = -1
queue = [None for _ in range(SIZE)]
bts_array = ['정국', '뷔', '지민', '진', '슈가', '랩몬스터']


if __name__ == "__main__":
    for i in range(0, SIZE, 1):
        en_queue(bts_array[i])
    while not is_queue_empty():
         print(f'대기 줄 상태 : {list(queue)}')
         print(f'{de_queue()} 님이 식당에 들어감')



