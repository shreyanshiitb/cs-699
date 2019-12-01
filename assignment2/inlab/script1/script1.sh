#!/bin/bash


N=$1
twiceSum=$(($N*$(($N+1))))
echo $(($twiceSum/2))

