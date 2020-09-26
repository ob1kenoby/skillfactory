from random import randint

size = 10000

to_sort = [randint(1, size) for i in range(size)]
print(to_sort)

for i in range(len(to_sort)):
    m = i
    for j in range(i + 1, len(to_sort)):
        if to_sort[m] > to_sort[j]:
            m = j
    to_sort[m], to_sort[i] = to_sort[i], to_sort[m]

print(to_sort)
