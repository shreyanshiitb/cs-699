str1 = input()
dict1 = {}
for i in str1:
	if i in dict1.keys():
		dict1[i]+=1
	else:
		dict1[i] = 1
dict2 = dict(sorted(dict1.items(),key=lambda x: (x[1], x[0]),reverse=True))
for i in dict2:
	print(i,dict2[i],sep=': ')



