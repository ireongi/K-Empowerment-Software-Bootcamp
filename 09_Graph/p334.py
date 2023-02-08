## 클래스 및 함수 선언 부분 ##
class Graph():
    def __init__(self, size):
        self.SIZE = size
        self.graph = [[0 for _ in range(size)] for _ in range(size)]


## 전역 변수 선언 부분 ##
G1 = None
stack = []
visited_array = []  # 방문한 정점
name_array = ['문별', '솔라', '휘인', '쯔위', '선미', '화사']
문별, 솔라, 휘인, 쯔위, 선미, 화사 = 0, 1, 2, 3, 4, 5


## 메인 코드 부분 ##
G1 = Graph(6)
G1.graph[문별][솔라] = 1; G1.graph[문별][휘인] = 1
G1.graph[솔라][문별] = 1; G1.graph[솔라][쯔위] = 1
G1.graph[휘인][문별] = 1; G1.graph[휘인][쯔위] = 1
G1.graph[쯔위][솔라] = 1; G1.graph[쯔위][휘인] = 1; G1.graph[쯔위][선미] = 1; G1.graph[쯔위][화사] = 1
G1.graph[선미][쯔위] = 1; G1.graph[선미][화사] = 1
G1.graph[화사][쯔위] = 1; G1.graph[화사][선미] = 1

print('## G1 무방향 그래프 ##')
for row in range(6):
    for col in range(6):
        print(G1.graph[row][col], end=' ')
    print()

current = 0  # 시작 정점 A
stack.append(current)
visited_array.append(current)

while len(stack) != 0:
    next = None
    for vertex in range(6):
        if G1.graph[current][vertex] == 1:
            if vertex in visited_array:  # 방문한 적이 있는 정점이면 탈락
                pass
            else:  # 방문한 적이 없으면 다음 정점으로 지정
                next = vertex
                break

    if next != None:  # 다음에 방문할 정점이 있는 경우
        current = next
        stack.append(current)
        visited_array.append(current)
    else:  # 다음에 방문할 정점이 없는 경우
        current = stack.pop()

print('방문 순서 -->', end='')
for i in visited_array:
    print(name_array[i], end='   ')
