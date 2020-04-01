import sys
count = 0

for line in sys.stdin:
    data = line.strip().split()
    
    if data[0] == "0":
        break
        
    if count != 0:
        print()
    count = count + 1
    
    x = [int(i) for i in data]
    k = x[0]
    s = x[1 : ]
    
    for a in range(0, k-5):
        for b in range(a + 1, k-4):
            for c in range(b + 1, k-3):
                for d in range(c + 1, k-2):
                    for e in range(d + 1, k-1):
                        for f in range(e + 1, k):
                            print(s[a], s[b], s[c], s[d], s[e], s[f])