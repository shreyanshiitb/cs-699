def fib():
    i0=0
    i1=1
    yield(i0)
    yield(i1)
    while True:
        i0,i1 = i1,i0+i1
        yield i1
        

x = fib()
print(x.__next__())
print(x.__next__())
print(x.__next__())
print(x.__next__())
print(x.__next__())

