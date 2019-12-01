CC = g++
OBJS = main.o hello.o factorial.o

hello: $(OBJS) 
	$(CC) -o hello factorial.o main.o hello.o

main.o: main.cpp functions.h
	$(CC) -c main.cpp 

factorial.o: factorial.cpp functions.h
	$(CC) -c factorial.cpp

hello.o: hello.cpp functions.h
	$(CC) -c hello.cpp

run:
	./hello

clean:
	rm -rf *.o

