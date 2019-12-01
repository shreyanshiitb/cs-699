import numpy as np
import pandas as pd
# you can import your favorite libraries here, as long as they run on SL2 machines

# Task 1
## create an nXn INTEGER matrix and store it with checkerboard pattern (using 0's and 1's). Top left corner should be 0. No loops. Assume n > 0.
def checkerboard(n):
    board = np.ones((n,n),dtype=int)
    board[::2,::2] = 0
    board[1::2,1::2] = 0
    return board

# Task 2
def SimpleNonLinearity(arr, leak):
    brr = np.where(arr<=0,arr,arr*leak).astype(float)
    return brr

# Task 3.1
## write a function to normalise an array of shape (m, n) along its columns. By normalise, we mean that mean of each column should be 0 and variance of each column is 1.
def normalise(arr):
    # compute mean (along columns) and reshape it into a row vector
    # then subtract this from each row of arr (let's call it mean_normalised)
    # then compute the std. deviation of the mean_normalised and reshape it into a row vector.
    # divide each row of mean_normalised by std.dev. to get the result.
    # write your code here
    col_mean = np.mean(arr,axis=0)
    col_std = np.std(arr,axis=0)
    return (arr-col_mean)/col_std

# Task 3.2
## Write a function mean_filter to implement a mean filter of 1-d array of shape (n,) and kernel size 2k+1. Output should be a float array. 
def mean_filter(arr, k):
    n=2*k+1
    arr = np.pad(arr,(k,k),mode='constant',constant_values=(0,0))
    arr = np.convolve(arr,np.ones(n)/n,mode='valid')
    return arr
    # write your code here
    
# Task 4 
# write a function to get the positions of top_k values of an each row of a matrix of shape (m,n).
"""
Concretely, if A is the input matrix of shape (m,n), then return an integer matrix R, such that:
R_{ij} is the index of an element in ith row of A which has rank j when that row is sorted in decreasing order. 
For example, if the input array ‘arr’ is:
[[ 6  4  4  7]
 [ 7  8  1  0]
 [11 10  5 11]]
Then top_k(arr, 2) will be:
[[3 0]
 [1 0]
 [3 0]]
Explanation for first row:
when we sort 6,4,4,7 in decreasing order, we get:
7, 6, 4, 4. Top 2 elements are 7 and 6. And, their positions in arr are: 3 and 0 respectively. 
So, the first row of result is 3,0.

Note: for breaking ties, higher indices should come first.(See the last row of result).
"""
def top_k(mat, k):
    # write your code here
    return np.fliplr(mat.argsort(axis=1))[:,:k]

# Task 5
# write a function which takes an array of shape (n,n) and returns either True or False, depending on whether the input was a magic square or not.
def is_magic_square(square):
    square = np.array(square)
    answer = set()
    distinct = np.unique(square.flatten())
    answer.update(np.sum(square,axis=0))
    answer.update(np.sum(square,axis=1))
    answer.add(np.trace(np.fliplr(square)))
    answer.add(np.trace(square))
    return 1 if len(answer)==1 and len(distinct)==square.size else 0
    # write your code here

# Task 6
#### separate file, not here! ####
