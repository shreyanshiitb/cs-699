CC=gcc
CFLAGS=-I. -pthread -Wall
DEPS = cl_task.h cl_utils.h
DIR = build
OBJ = $(DIR)/cl_task.o $(DIR)/cl_utils.o $(DIR)/mt_client.o

all: create ../mt_client.out

create:
	@mkdir -p $(DIR)

$(DIR)/cl_task.o: cl_task.c cl_task.h
	$(CC) -g -c -o $@ $<

$(DIR)/cl_utils.o: cl_utils.c cl_utils.h
	$(CC) -g -c -o $@ $<

$(DIR)/mt_client.o: mt_client.c $(DEPS)
	$(CC) -g -c -o $@ $< $(CFLAGS)


../mt_client.out: $(OBJ)
	$(CC) -g -o $@ $^ $(CFLAGS)

run:
	../mt_client.out $(IP_ADDR) $(PORT)

clean:
	rm -f $(DIR)/*.o