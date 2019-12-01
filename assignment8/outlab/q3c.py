import xmlrpc.client

client = xmlrpc.client.ServerProxy("http://localhost:8129/")
answer = True

while answer:
    answer = client.isPalin(input())
    print('Yes' if answer else 'No')