/open Circle.java

Circle c1 = new Circle(10);
Circle c2 = new Circle(10);
Object o1 = c1;
Object o2 = c2;

o1.equals(o2)
o1.equals((Circle) o2)
o1.equals(c2)
o1.equals(c1)
c1.equals(o2)
c1.equals((Circle) o2)
c1.equals(c2)
c1.equals(o1)

/exit