set term png
set output '2.png' 

set key at 2,3.5,2
set xyplane 1

func(x,y) = -x>y ? 1/0 : ((x+y)**3 )

set ticslevel 0
set xtics 2
set pm3d

splot [-5:5] [-5:5] [0:1000] func(x,y) lt rgb "orange"
