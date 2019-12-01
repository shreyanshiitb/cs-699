set term pngcairo dashed
set output '5.png'
set key reverse enhanced
set xrange [-10:10]
set yrange [-10:10]
poly(x)=0
poly1(x)=(x-2)*x
poly2(x)=(x-4)*x
poly3(x)=(x-6)*x
set style line 1 lw 1.5 dt 2 lc rgb '#999999'
set style line 2 lw 1.5 lc rgb '#b19cd9'
set style line 3 lw 1.5 lc rgb '#90ee90'
set style line 4 lw 1.5 lc rgb '#87ceeb'
plot poly(x) with lines ls 1,poly1(x) with lines ls 2,poly2(x) with lines ls 3,poly3(x) with lines ls 4
