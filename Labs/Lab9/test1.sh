#!/usr/bin/bash
javac -Xlint:rawtypes BusAPI.java
jar uf level1.jar BusAPI.class
echo "16189 Clementi" | java -jar level1.jar | diff - a.out -w