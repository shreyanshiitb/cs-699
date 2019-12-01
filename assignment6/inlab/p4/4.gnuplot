set term png
set output '4.png'
set size 1.0, 0.9
f(t) = cos(t)
g(t) = sin(t)
set style line 1 linecolor '#008000' linetype 1 linewidth 2
set parametric
plot [0:2*pi] f(t),g(t) with lines ls 1
