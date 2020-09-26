from random import randint

size = 10000

to_sort = [randint(1, size) for i in range(size)]
print(to_sort)
steps = len(to_sort)
changed = True
while steps > 0 and changed:
    changed = False
    for i in range(1, steps):
        if to_sort[i] < to_sort[i-1]:
            to_sort[i], to_sort[i-1] = to_sort[i-1], to_sort[i]
            changed = True
    steps -= 1
print(steps, to_sort)

