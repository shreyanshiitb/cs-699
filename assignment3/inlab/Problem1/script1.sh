
#!/bin/bash 

grep -E -o "\b[a-ZA-Z][a-zA-Z0-9._]*@[a-zA-Z]+[.][a-zA-Z.]+[a-zA-Z]\b" $1
