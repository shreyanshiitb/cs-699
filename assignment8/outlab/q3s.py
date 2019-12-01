from xmlrpc.server import SimpleXMLRPCServer
from ISPALIN import ISPALIN

server = SimpleXMLRPCServer(("localhost", 8129))
print("Listening on port 8129...")
server.register_function(ISPALIN, 'isPalin')
server.serve_forever()