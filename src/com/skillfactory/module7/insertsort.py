from random import randint

size = 10000

to_sort = [randint(1, size) for i in range(size)]
print(to_sort)

for i in range(1, len(to_sort)):
    j = i - 1
    key = to_sort[i]
    while j >= 0 and to_sort[j] > key:
        to_sort[j + 1] = to_sort[j]
        j -= 1
    to_sort[j + 1] = key

print(to_sort)