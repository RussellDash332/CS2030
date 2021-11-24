#!/usr/bin/bash
javac *.java cs2030/simulator/*.java
# add your checkstyle script here...

# 0a 0b 1a 1b 1c 2a 2b 2c 2d 3a 3b 3c 4a 4b 4c 5a 5b 5c 5d 5e 5f 5g 5h 5i
# 5f2 and 5i2 are the long versions, use wisely

for lvl in 0a 0b 1a 1b 1c 2a 2b 2c 2d 3a 3b 3c 4a 4b 4c 5a 5b 5c 5d 5e 5f 5f2 5g 5h 5i 5i2
do
    echo Testing level $lvl...
    java Main${lvl:0:1} < tests/$lvl.in | diff - tests/$lvl.out -w
done
echo All good!