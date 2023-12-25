n = 1000 - int(input())
coins = [500, 100, 50, 10, 5, 1]
count = 0
for coin in coins:
    count = n // coin
    n = n % coin
    if n == 0:
        break

print(count)

