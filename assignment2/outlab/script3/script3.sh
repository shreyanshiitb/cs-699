#!/bin/bash

sum=0
dir=$1

#small check to extract files only
files=`ls -l $dir | grep ^- | awk '{print $9}'`

for file in $files
do
	file=$dir/$file
	((sum+=$(grep -cve '^\s*$' $file)))

done
echo $sum
