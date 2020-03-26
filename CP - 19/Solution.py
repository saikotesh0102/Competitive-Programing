scale = ['C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'A#', 'B']
major_scale = {
    0: [0, 2, 4, 5, 7, 9, 11, 0],
    1: [1, 3, 5, 6, 8, 10, 0, 1],
    2: [2, 4, 6, 7, 9, 11, 1, 2],
    3: [3, 5, 7, 8, 10, 0, 2, 3],
    4: [4, 6, 8, 9, 11, 1, 3, 4],
    5: [5, 7, 9, 10, 0, 2, 4, 5],
    6: [6, 8, 10, 11, 1, 3, 5, 6],
    7: [7, 9, 11, 0, 2, 4, 6, 7],
    8: [8, 10, 0, 1, 3, 5, 7, 8],
    9: [9, 11, 1, 2, 4, 6, 8, 9],
    10: [10, 0, 2, 3, 5, 7, 9, 10],
    11: [11, 1, 3, 4, 6, 8, 10, 11],
}

while True:
    line = input().strip()
    if line == "END":
        break
    unique = list(set(line.split()))
    unique = [scale.index(t) for t in unique]
    res = []
    for t, ms in major_scale.items():
        if (all(x in ms for x in unique)):
            res.append(scale[t])
    print(' '.join(res))