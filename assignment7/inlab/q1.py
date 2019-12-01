import math

def isSquare(m):
	if(math.ceil(math.sqrt(m)==math.floor(math.sqrt(m)))):
		print(m,  "is a square number")
	else :
		print(m,  "is not a square number")
		
		
n=int(input())
arr = []
for _ in range(n):
    x = int(input())
    arr.append(x)
    
for i in range(n):
	isSquare(arr[i])