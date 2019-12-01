#!/bin/bash

count=$(cat $1 $2 $3 | wc -w )
cat $1 $2 $3 | grep -o -E -e "[A-Za-z']+['’][A-Za-z]+" -e "[A-Za-z]+" | sort -f | uniq -c -i | awk -v var="$count" '{ print $1/var" "$2}'