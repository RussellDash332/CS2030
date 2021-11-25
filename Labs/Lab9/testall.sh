#!/usr/bin/bash
for lvl in 1 2 3 4
do
    echo Testing level $lvl...
    ./test$lvl.sh
    echo
done