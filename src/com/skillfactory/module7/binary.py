from random import randint

size = 10000

to_sort = [randint(1, size) for i in range(size)]
print(to_sort)


def quicksort(lis):
    # print(lis)
    j = -1
    i = 0
    for i in range(len(lis)):
        if lis[i] <= lis[len(lis) - 1]:
            j += 1
            lis[i], lis[j] = lis[j], lis[i]
    if j != i and j >= 0:
        lis[j + 1], lis[len(lis) - 1] = lis[len(lis) - 1], lis[j + 1]
        # print(lis)
        left = quicksort(lis[:j])
        right = quicksort(lis[j:])
        lis = left + right
    # print(lis)
    return lis


def binary_search(x, y):
    m = len(y) // 2
    l = 0
    h = len(y)
    while x != y[m] and l <= h:
        if x > y[m]:
            l = m + 1
        else:
            h = m - 1
        m = (l + h) // 2
    return m


to_check = [to_sort[randint(0,size)] for _ in range(10)]
y = quicksort(to_sort)
print(y)
print()
print(to_check)
for i in to_check:
    print(i, y[binary_search(i, y)])
#print(2, binary_search(2, y))