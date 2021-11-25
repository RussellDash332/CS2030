#!/usr/bin/bash
javac -Xlint:rawtypes Main.java
echo Part 1
echo "16189 Clementi" | java Main | diff - a.out -w
echo
echo Part 2
cat minitest.in | java Main | diff - b.out -w
echo
echo Part 3
cat test.in | java Main