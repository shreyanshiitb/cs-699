#!/bin/bash

sum=0
max=-1000
max2=-1000

for i in `cat $1`;
do
    if (($max < $i)) 
    then
        max=$i
    fi
done;

for i in `cat $1`; 
do
    if (($max2 < $i && $i != $max)) 
    then
        max2=$i
    fi
done;

echo $(($max + $max2))
echo $(($max*$max2))
