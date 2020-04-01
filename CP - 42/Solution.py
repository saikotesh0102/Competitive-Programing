import itertools

while True:
    line = input().split()

    n = int(line[0])
    m = int(line[1])

    if n == 0 and m == 0:
        break
        
    constraints = []
    for i in range(m):
        line = input().split()
        a = int(line[0])
        b = int(line[1])
        c = int(line[2])

        constraints.append((a,b,c))
        
    nums = range(n)
    
    perm_count = 0
    
    for perm in itertools.permutations(nums):
        count = 0
        locations = {}

        for i in perm:
            locations[i] = count
            count = count + 1

        flag = True
        for (a, b, c) in constraints:
            if c >= 0:
                if abs(locations[a] - locations[b]) > c:
                    flag = False
                    break
            else:
                if abs(locations[a] - locations[b]) < -c:
                    flag = False
                    break

        if flag == True:
            perm_count = perm_count + 1

    print(perm_count)