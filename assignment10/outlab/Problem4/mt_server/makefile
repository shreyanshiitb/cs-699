CC=gcc
CFLAGS=-I. -pthread -Wextra
DEPS = sv_task.h sv_utils.h
DIR = build
OBJ = $(DIR)/mt_server.o $(DIR)/sv_task.o $(DIR)/sv_utils.o

all: create ../mt_server.out

create:
	@mkdir -p $(DIR)

$(DIR)/sv_task.o: sv_task.c sv_task.h sv_utils.h
	$(CC) -g -c -o $@ $<

$(DIR)/sv_utils.o: sv_utils.c sv_utils.h
	$(CC) -g -c -o $@ $<

$(DIR)/mt_server.o: mt_server.c $(DEPS)
	$(CC) -g -c -o $@ $< $(CFLAGS)


../mt_server.out: $(OBJ)
	$(CC) -g -o $@ $^ $(CFLAGS)

run:
	../mt_server.out $(PORT)

clean:
	rm -f $(DIR)/*.o