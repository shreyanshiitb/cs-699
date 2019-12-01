#!/bin/bash

awk '{
    OFS="\t";
    if(NR==1)
    print $1,$2,$3,$4,"Points"
    else
    print $1,$2,$3,$4,(($3*4+$4*2))
}' $1