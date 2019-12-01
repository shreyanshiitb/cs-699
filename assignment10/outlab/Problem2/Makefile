# # helloMake: hello.cpp main.cpp factorial.cpp
# # 	gcc -o hello hello.cpp -o hello.o factorial.cpp -o factorial.o  

hello: main.o hello.o factorial.o 
	g++ -o hello factorial.o main.o hello.o

main.o: main.cpp functions.h
	g++ -c main.cpp 

factorial.o: factorial.cpp functions.h
	g++ -c factorial.cpp

hello.o: hello.cpp functions.h
	g++ -c hello.cpp

# .PHONY: clean

run:
	./hello

clean:
	rm -f *.o


# peer.o: peer.cpp
# 	g++ peer.cpp -o peer.o

# server.o: server.cpp peerinfo.hpp
# 	g++ server.cpp -o server.o


# main.o : main.o
# 	g++ main.cpp -o main.o

# hello.o : hello.o
# 	g++ hello.cpp -o hello.o

# factorial.o : factorial.o
# 	g++ factorial.cpp -o factorial.o

# hello: 
# 	g++ 