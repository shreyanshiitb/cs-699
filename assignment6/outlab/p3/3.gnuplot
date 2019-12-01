set term png
set output "3.png"

set xtics rotate by 60 right
set ytics 3,1,10
set xtics 0,1,22

set style textbox opaque
set xlabel 'Roll No. -->'
set ylabel 'Gradepoint -->'

set grid ytics lc rgb "#bbbbbb" lw 1 lt 0
set grid xtics lc rgb "#bbbbbb" lw 1 lt 0
set datafile separator ","

plot [0:22] [3:11]"Plot3Data.csv" using 1 :( $2<=39 ? 4 : $2<=44 ? 5 : $2<=49 ? 6 : $2<=54 ? 7 : $2<=59 ? 8 : $2<=69 ? 9 : 10) w l t "Grade Chart" lw 3.5 lt rgb '#9400D3', 'Plot3Data.csv' using 1 : ( $2<=39 ? 4 : $2<=44 ? 5 : $2<=49 ? 6 : $2<=54 ? 7 : $2<=59 ? 8 : $2<=69 ? 9 : 10):(sprintf('%d',$2)) with labels boxed notitle


