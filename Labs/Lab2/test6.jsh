/open Cruise.java
/open SmallCruise.java
/open BigCruise.java
/open Loader.java
/open RecycledLoader.java
/open level6.jsh
Cruise[] cruises = {
    new BigCruise("B1111", 0, 60, 1500),
    new SmallCruise("S1112", 0), 
    new BigCruise("B1113", 30, 100, 1500),
    new BigCruise("B1114", 100, 100, 1500),
    new BigCruise("B1115", 130, 100, 1500),
    new BigCruise("B1116", 200, 100, 1500)}
serveCruises(cruises);
/exit