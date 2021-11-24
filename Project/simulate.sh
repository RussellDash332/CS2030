#!/usr/bin/bash
javac *.java cs2030/simulator/*.java
java -jar ~/../../mnt/c/Users/user/Documents/NUS/'NUS Y2S1'/CS2030/checkstyle-8.2-all.jar -c ~/../../mnt/c/Users/user/Documents/NUS/'NUS Y2S1'/CS2030/cs2030_checks.xml *.java cs2030/simulator/*.java

# 0a 0b 1a 1b 1c 2a 2b 2c 2d 3a 3b 3c 4a 4b 4c 5a 5b 5c 5d 5e 5f 5g 5h 5i

for lvl in 0a 0b 1a 1b 1c 2a 2b 2c 2d 3a 3b 3c 4a 4b 4c 5a 5b 5c 5d 5e 5f 5g 5h 5i
do
    echo Testing level $lvl...
    java Main${lvl:0:1} < tests/$lvl.in | diff - tests/$lvl.out -w
done
echo All good!