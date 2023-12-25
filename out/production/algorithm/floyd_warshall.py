INF = float('inf')

def floyd_warshall(graph):
    n = len(graph)
    dist = [[INF] * n for _ in range(n)]
    next_node = [[None] * n for _ in range(n)]

    for u in range(n):
        for v, weight in graph[u]:
            dist[u][v] = weight
            next_node[u][v] = v

    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
                    next_node[i][j] = next_node[i][k]

    cycle = None
    min_cycle_length = INF

    for u in range(n):
        if dist[u][u] < min_cycle_length:
            min_cycle_length = dist[u][u]

    return min_cycle_length

t = int(input())
for i in range(t):
    N, M = map(int, input().split())
    graph = [[] for _ in range(N)]
    
    for _ in range(M):
        x, y, c = map(int, input().split())
        graph[x-1].append((y-1,c))    
    
    
    shortest_cycle = floyd_warshall(graph)
    print("#%d %d" %(i, shortest_cycle))
