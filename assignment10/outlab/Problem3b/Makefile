# CC = g++
# OBJS = main.o hello.o factorial.o
# TARGET = hello main.o hello.o factorial.o
# normal: $(TARGET)
# # ODIR=obj

# hello: $(OBJS) 
# 	$(CC) -o hello factorial.o main.o hello.o

# main.o: main.cpp functions.h
# 	$(CC) -c main.cpp 

# factorial.o: factorial.cpp functions.h
# 	$(CC) -c factorial.cpp

# hello.o: hello.cpp functions.h
# 	$(CC) -c hello.cpp

CC=gcc
CFLAGS=-I.
DEPS = hellomake.h
OBJ = hellomake.o hellofunc.o 

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

hellomake: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)

run:
	./hellomake

clean:
	rm -rf *.o