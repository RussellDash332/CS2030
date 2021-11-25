/open Point.java
/open Circle.java

List<Circle> getCircles(int n) {
    return Stream.<Double>iterate(1.0, x -> x + 1)
        .limit(n)
        .map(x -> new Circle(new Point(x, n + 1 - x)))
        .collect(Collectors.toList());
}

getCircles(10)
getCircles(11)
/exit