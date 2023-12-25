import sys

for _ in range(int(sys.stdin.readline())):
    m = sys.stdin.readline()
    res = 'OK'
    msg = [0] * 26

    for i in range(len(m)-1):
        msg[ord(m[i])-65] += 1
        if(msg[ord(m[i])-65] == 3):
            if(m[i] != m[i+1] or i == len(m)-1):
                res = 'FAKE'
                break
            msg[ord(m[i])-65] = -1
    
    print(res)