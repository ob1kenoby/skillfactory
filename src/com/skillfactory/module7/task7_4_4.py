from random import randint

size = 20

to_sort = [randint(1, size * 5) for i in range(size)]
print(to_sort)


def sorter(y):
    for i in range(len(y)):
        b = y[i]
        j = i - 1
        while j >= 0 and b < y[j]:
            y[j + 1] = y[j]
            j -= 1
        y[j + 1] = b
    return y


def binary_append(x, y):
    m = len(y) // 2 - 1
    l = 0
    h = len(y)
    while l < h:
        if x == y[m]:
            break
        if x > y[m]:
            l = m + 1
        else:
            h = m - 1
        m = (l + h) // 2
    left = y[:m]
    right = y[m:]
    left.append(x)
    return left + right


to_insert = sorter(to_sort)
print(to_insert)
x = int(input("Введите число:"))  # randint(0, size)
print(x)
inserted = binary_append(x, to_insert)
print(inserted)