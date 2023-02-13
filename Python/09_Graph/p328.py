class Graph():
    def __init__ (self, size):
        self.SIZE = size
        self.graph = [[0 for _ in range(size)] for _ in range(size)]


g1 = None
g1 = Graph(6)
array = ['a', 'b', 'c', 'd', 'e', 'f']
a, b, c, d, e, f = 0, 1, 2, 3, 4, 5


g1.graph[a][b] = 1; g1.graph[a][c] = 1
g1.graph[b][a] = 1; g1.graph[b][d] = 1
g1.graph[c][a] = 1; g1.graph[c][d] = 1
g1.graph[d][b] = 1; g1.graph[d][c] = 1; g1.graph[d][e] = 1; g1.graph[d][f] = 1
g1.graph[e][d] = 1; g1.graph[e][f] = 1
g1.graph[f][d] = 1; g1.graph[f][e] = 1


print(' ', end= ' ')
for i in range(g1.SIZE):
    print(array[i], end=' ')
print()


for row in range(g1.SIZE):
    print(array[row], end=' ')
    for col in range(0, 6):
        print(g1.graph[row][col], end=' ')
    print()