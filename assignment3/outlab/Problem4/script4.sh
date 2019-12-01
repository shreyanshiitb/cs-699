#!/bin/bash

sed -e 's/^Email.*:/||/g' -e 's/\s\+/ /g' -e 's/^\s\+//g' -e '/^$/d' $1 |

awk '
    BEGIN {name=1;print "Name||Address||EmailID"}
    {
    if($1 == "||"){
        print $0;
        name=1;
    }
    else if(name == 1){
        printf("%s||",$0);
        name=0;
    }
    else
        printf("%s",$0);
}' | sed -e 's/ ||/||/g' -e 's/||\s/||/g'