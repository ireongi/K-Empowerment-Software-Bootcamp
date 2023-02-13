class Graph():
    def __init__ (self, size):
        self.SIZE = size
        self.graph = [[0 for _ in range(size)] for _ in range(size)]


g1 = None
g1 = Graph(4)

print(g1)

g1.graph[0][3] = 1
g1.graph[1][2] = 1; g1.graph[1][3] = 1
g1.graph[2][1] = 1
g1.graph[3][0] = 1; g1.graph[3][1] = 1


for row in range(4):
    for col in range(4):
        print(g1.graph[row][col], end=' ')
    print()