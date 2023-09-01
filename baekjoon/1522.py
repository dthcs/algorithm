s = input()
a_cnt = s.count("a")

s += s[0:a_cnt-1]
ans = float('inf')

for i in range(len(s)-a_cnt+1):
    ans = min(ans, s[i:a_cnt+i].count("b"))

print(ans)
