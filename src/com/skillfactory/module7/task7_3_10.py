Y = [19, 2, 31, 35, 30, 11, 121, 27]

for i in range(len(Y)):
    b = Y[i]
    j = i - 1
    while j >= 0 and b < Y[j]:
        Y[j+1] = Y[j]
        j -= 1
    Y[j+1] = b

print(Y)