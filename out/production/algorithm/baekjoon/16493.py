# import system

# input = sys.stdin.readline

day_num, chapter_num = map(int, input().split())

res_table = [[0 for _ in range(day_num+1)] for _ in range(chapter_num+1) ]

day_list = []
page_list = []

for _ in range(chapter_num):
    day, page = map(int, input().split())
    day_list.append(day)
    page_list.append(page)
    
for i in range(1, chapter_num+1):
    for j in range(1, day_num+1):
        if(day_list[i-1] > j ):
            res_table[i][j] = res_table[i-1][j]
        else:
            res_table[i][j] = max(res_table[i-1][j], page_list[i-1]+res_table[i-1][j-day_list[i-1]])
            
# print(res_table)
          
print(res_table[chapter_num][day_num])