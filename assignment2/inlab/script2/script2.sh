#!/bin/bash


echo `ls -l $1 | grep ^d | wc -l`


# to count hidden folders ---> echo `ls -la $1 | grep ^d | wc -l`
