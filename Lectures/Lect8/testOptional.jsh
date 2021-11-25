import java.util.Optional;

Circle createUnitCircle(Point p, Point q) {
    final double UNIT_RADIUS = 1;
    Point mid = p.midPoint(q);
    double theta = p.angleTo(q);
    double pq = p.distanceTo(q);
    double d = Math.sqrt(Math.pow(UNIT_RADIUS, 2) - Math.pow(pq / 2, 2));
    Point centre = mid.moveTo(theta + Math.PI / 2, d);
    return new Circle(centre, UNIT_RADIUS);
}

Optional<Circle> createUnitCircle(Point p, Point q) {
    double d = p.distanceTo(q);
    if (d > 0.0 && d <= 2.0) {
        Point mid = p.midPoint(q);
        double theta = p.angleTo(q);
        double disp = Math.sqrt(1 - Math.pow(d / 2, 2));
        Point centre = mid.moveTo(theta + Math.PI / 2, disp);
        return Optional.<Circle>of(new Circle(centre, 1));
    } else {
        return Optional.empty();
    }
}

createUnitCircle(new Point(0, -1), new Point(0, 1))
createUnitCircle(new Point(0, -1), new Point(0, 10))

createUnitCircle(new Point(0, -1), new Point(0, 1)).
filter(x -> x.contains(new Point(0.5, 0.5))).
ifPresent(x -> System.out.println(x))

createUnitCircle(new Point(0, -1), new Point(0, 10)).
filter(x -> x.contains(new Point(0.5, 0.5))).
ifPresent(x -> System.out.println(x))

createUnitCircle(new Point(0, -1), new Point(0, 1)).
filter(x -> x.contains(new Point(1, 1))).
ifPresent(x -> System.out.println(x))

/exit
