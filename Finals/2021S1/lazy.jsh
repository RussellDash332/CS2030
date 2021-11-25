/open processed/LazyList.java
LazyList.intRange(101, 200).filter(n-> n%2==0)
System.out.println("done")
LazyList.intRange(2, 100).map(n-> 2*n).filter(n-> n > 11)
System.out.println("done")
LazyList.intRange(10, 20).map(n-> 50-n).filter(n-> n < 20)
/exit