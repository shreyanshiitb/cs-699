#!/bin/bash

sed -e 's/\s\+/ /g' -e 's/^\s\+//g' -e '/^$/d' $1
