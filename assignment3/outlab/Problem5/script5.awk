#!/bin/bash

 BEGIN{FS=OFS=","} {arr[$2]+=$3} END{for (i in arr) print i,arr[i]|"sort -k1"}
