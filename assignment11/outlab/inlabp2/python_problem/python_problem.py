"""@package python_problem
The function involves:
1.Reading from file
2.Making a list from file input
3.Sorting List
4.Doing a binary search on sorted list
5.Finding determinant of square matrix
"""
from sys import argv
from copy import deepcopy

## 
# @brief Making a list from file input
# @param filename : The file location of the datafile
# @return l : integer list
#
def make(filename):
	""" 
	Parameters
    ----------
    filename : str
        The file location of the datafile

    Returns
    -------
	l : integer list
	"""
	file = open (filename)
	l=[]
	for line in file:
		a=int(line)
		l.append(a)
	return l

## 
# @brief A function to sort a list in ascending order Parameters
# @param l : integer list
# @return l : integer list sorted in ascending order
#
def fun1(l):
	""" 
	A function to sort a list in ascending order
	Parameters
    ----------
    l : integer list

    Returns
    -------
	l : integer list
		sorted in ascending order
	"""
	size=len(l)
	for i in range(0,size-1):
		for j in range(0,size-i-1):
			if l[j] > l[j+1]:
				temp=l[j]
				l[j]=l[j+1]
				l[j+1]=temp
	return l

## 
# @brief A function to do a Binary Search 
# @param l : integer list
# @param x : Element to be searched in sorted list l
# @return probes : number of comparisons done to search x in list l
#					-1 if x not found in list l
def fun2(l,x):
	""" 
	A function to do a Binary Search
	Parameters
    ----------
    l : integer list
		sorted in ascending order

    x : int
        Element to be searched in sorted list l

    Returns
    ------- 
	probes : number of comparisons done to search x in list l
	-1 if x not found in list l
	"""
	n=int(x)
	probes=0
	s=0
	e=len(l)-1
	flag=0
	while(s<=e):
		probes=probes+1
		m=(s+e)//2
		print ("Probe "+str(probes)+":",m,l[m])
		if(l[m]==n):
			flag=1
			break
		elif(l[m]>n):
			e=m-1
		elif(l[m]<n):
			s=m+1
	if(flag==1):
		return probes
	else:	
		return -1


## 
# @brief A function to calculate determinant of a square matrix
# @param L : 2-D square matrix
# @return d : determinant of square matrix
#
def fun3(L):
	""" 
	A function to calculate determinant of a square matrix
	Parameters
    ----------
    L : list
		2-D square matrix

    Returns
    -------
	d : int
		determinant of square matrix
	"""
	d=0
	n=len(L)
	if(n==1):
		return L[0][0]
	for i in range(0,n):
		A=deepcopy(L)
		for j in range(0,len(A)):
			A[j].pop(i)
		A.pop(0)
		d=d+L[0][i]*((-1)**i)*fun3(A)
	return d

## @var L
# variable to hold List from make function
L = make("data")
print (L)
L = fun1(L)
print ("\nAfter Fun1:")
print (L)
print ("\nFun2 Starts:")

## @var ans
# variable to hold result from fun2 function
ans = fun2(L, 48)
print ("Result of Fun2:", ans)

print ("\n")
# Change the elements and observe the result  
L = [[1, 2, 3], [100, 54, 23], [9, 27, 11]]
print(L)
ans = fun3(L)
print ("Result of Fun3:", ans)
