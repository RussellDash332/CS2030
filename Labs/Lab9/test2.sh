#!/usr/bin/bash
javac -Xlint:rawtypes BusService.java
jar uf level2.jar BusAPI.class BusService.class BusStop.class
echo "16189 Clementi" | java -jar level2.jar | diff - a.out -w