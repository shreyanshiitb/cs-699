#The pond symbol is used for writing the comments.

#make file overview :--	
#you can add a little description here.

# #variable declaration :-
# cc=g++    
# # // this is the variable which is used in the target.
# MAKE=make
# RM =rm

# #targets .
# all: peer.cpp server.cpp
# 	$(cc) -o peer peer.cpp	
# 	$(cc) -o server server.cpp
# 	# gnome-terminal -t server --working-directory=/home/markzuck/Desktop/team-name/Problem1 -e "./server"
# 	# sleep 10s 
# 	$(MAKE) client_target	


# #another target for client
# client_target:
# 	./client  

# clean:server client
# 	$(RM) server
# 	$(RM) client

TARGET = peer.o server.o
normal: $(TARGET)

peer.o: peer.cpp
	g++ peer.cpp -o peer.o

server.o: server.cpp peerinfo.hpp
	g++ server.cpp -o server.o

run:
	./server.o 8225
	./peer.o 8120 localhost 8225

clean:
	rm -rf *.o
