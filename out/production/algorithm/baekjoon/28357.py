N, K = map(int, input().split())
A = list(map(int, input().split()))

low, high = 0, max(A)

while low < high:
    mid = (low + high) // 2

    s = sum(x - mid for x in A if x > mid)
    if s <= K:
        high = mid
    else:
        low = mid + 1

print(high)