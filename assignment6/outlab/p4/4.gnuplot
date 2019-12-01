set term png
set output "4.png"


ack1(m,n) = (m != 0) ?  (n == 0) ? ack1(m-1,1) : ack1(m-1,ack1(m,n-1)) : n + 1 

ack(x,y) = ack1(int(x),int(y))
set xrange [0:3]
set yrange [0:3]

set isosamples 4	
set samples 4
set title "Ackermann function"
set key font "Verdana,12"
set style function lines


splot ack(x, y) title "ack(x,y)" lt rgb "#21908d" lw 2
