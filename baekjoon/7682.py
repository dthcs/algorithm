def flag(arr, equ):
    if arr[0][0] == arr[0][1] == arr[0][2] == equ:
        return True
    if arr[0][0] == arr[1][0] == arr[2][0] == equ:
        return True
    if arr[0][0] == arr[1][1] == arr[2][2] == equ:
        return True
    if arr[1][0] == arr[1][1] == arr[1][2] == equ:
        return True
    if arr[2][0] == arr[2][1] == arr[2][2] == equ:
        return True
    if arr[2][0] == arr[1][1] == arr[0][2] == equ:
        return True
    if arr[0][1] == arr[1][1] == arr[2][1] == equ:
        return True
    if arr[0][2] == arr[1][2] == arr[2][2] == equ:
        return True
    return False

while True:
    string = input()
    if string == "end":
        break
    else:
        x_count = 0
        o_count = 0
        index = 0
        arr = [[0]*3 for _ in range(3)]
        for i in range(3):
            for j in range(3):
                arr[i][j] = string[index]
                if string[index] == "X":
                    x_count += 1
                if string[index] == "O":
                    o_count += 1
                index += 1
            
        if x_count > o_count+1:
            print("invalid")
            continue
        if x_count == o_count+1:
            if not flag(arr, "O") and flag(arr, "X"):
                print("valid")
                continue
        if x_count == o_count:
            if flag(arr, "O") and not flag(arr, "X"):
                print("valid")
                continue
        if x_count < o_count:
            print("invalid")
            continue
        if x_count==5 and o_count==4:
            if not flag(arr, "O"):
                print("valid")
                continue
        print("invalid")