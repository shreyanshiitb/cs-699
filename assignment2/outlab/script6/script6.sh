#!/bin/bash

#case insensitive


cp $1 output
for cuss in `cat $2`
do	
	for lyric in `cat output`
	do
		if [ ${cuss^^} = ${lyric^^} ]; then
			mint=`cat output`
			echo ${mint/$lyric/"bleep"} > output
		fi
	done
done
