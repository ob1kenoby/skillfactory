from random import randint

size = 10000

to_sort = [randint(1, size) for i in range(size)]
print(to_sort)


def mergesort(list_to_sort):
    if len(list_to_sort) == 1:
        return list_to_sort
    else:
        middle = len(list_to_sort) // 2
        if len(list_to_sort) % 2 == 1:
            middle += 1
        left = list_to_sort[:middle]
        right = list_to_sort[middle:]
        left = mergesort(left)
        right = mergesort(right)
        result = []
        while len(left) > 0 and len(right) > 0:
            if left[0] > right[0]:
                result.append(right.pop(0))
            else:
                result.append(left.pop(0))
        for i in left:
            result.append(i)
        for i in right:
            result.append(i)
        return result


print(mergesort(to_sort))




