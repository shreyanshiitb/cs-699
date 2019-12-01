PORT = 6544
IP_ADDR = localhost

export PORT
export IP_ADDR

all: linkserver linkclient

linkserver:
	$(MAKE) --directory mt_server

linkclient:
	$(MAKE) --directory mt_client

run:
	gnome-terminal -- $(MAKE) --directory=mt_server run
	gnome-terminal -- $(MAKE) --directory=mt_client run

.PHONY: clean

clean:
	rm -rf mt_client/build
	rm -rf mt_server/build
	rm -f mt_client.out
	rm -f mt_server.out