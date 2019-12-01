#!/bin/bash

case $2 in
     -lines)
       echo  $(awk 'END{print NR}' $1) lines
          ;;
     -words)
	echo  $(awk 'BEGIN{count=0;}{count+=NF}END{print count}' $1) words 
          ;;
     -chars)
       sed -e 's/\s//g' $1 | echo  $( awk '{t+=length($0)}END{print t}') characters
          ;; 
     -paras)
         echo $( awk -v RS='\n\n+' 'END{print NR}' $1 ) paragraphs
          ;; 
     *)
	sed -e 's/\s//g' $1 | echo $( awk '{t+=length($0)}END{print t}') characters, $(awk 'BEGIN{count=0;}{count+=NF}END{print count}' $1) words, $(awk 'END{print NR}' $1) lines, $( awk -v RS='\n\n+' 'END{print NR}' $1 ) paragraphs 
          ;;
esac