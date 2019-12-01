#!/bin/bash

for i in `cat $1`
do  
    if [ ! -d "$i" ]; then
        `mkdir $i`
        echo "created $i"
    else echo "could not create $i"
    fi
done
