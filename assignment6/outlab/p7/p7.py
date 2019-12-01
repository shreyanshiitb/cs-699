dict1 = {}
visited = set()
runs = {}
matches = int(input())
for match in range(matches):
    matchstats = input()
    matchnum,val = matchstats.split(':')
    right = dict((name.strip(), int(score.strip())) for name, score in (playerstat.split('-') for playerstat in val.split(',')))
    for player in tuple(right): 
        if not player in visited: 
            visited.add(player) 
            runs[player] = right[player]
        else:
            runs[player] = runs[player]+right[player]
    dict1[matchnum]=right
print(dict1)
print(sorted(runs.items(), key=lambda player: (player[1],player[0]), reverse=True))
