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


print(quicksort(to_sort))