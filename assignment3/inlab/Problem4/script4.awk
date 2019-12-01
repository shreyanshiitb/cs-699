
BEGIN { RS="!";FS=","; print "Value\tSensorNumber"} {print $1"\t"$2}
