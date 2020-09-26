from random import randint

size = 10

# to_sort = [randint(1, size) for i in range(size)]
to_sort = [size - i + 1 for i in range(size)]
print(to_sort)

d = len(to_sort) // 2
while d > 0:
    for i in range(d, len(to_sort)):
        temp = to_sort[i]
        j = i
        while j >= d and to_sort[j-d] > temp:
            # print(f'd = {d}, i = {i}, j = {j}, j-d = {j-d}, temp = {temp}\n{to_sort}')
            to_sort[j] = to_sort[j-d]
            j -= d
        to_sort[j] = temp
    d = d // 2

print(to_sort)
