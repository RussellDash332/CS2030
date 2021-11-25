#!/usr/bin/bash
javac -Xlint:rawtypes BusSg.java
jar uf level3.jar BusAPI.class BusService.class BusStop.class BusSg.class BusRoutes.class
echo "16189 Clementi" | java -jar level3.jar | diff - a.out -w