#!/bin/bash

touch temp
touch temp2
touch output
while IFS= read -r line; do
	echo $line > temp
	cut -d "," -f 1,2-3 temp >> temp2
	cut -d "," -f 1,4-5 temp >> temp2
	cut -d "," -f 1,6-7 temp >> temp2
done < "$1"
rm temp
sort -t ',' -k1,1 -k2,2 temp2 > output
rm temp2
