Random rand = new Random()
Circle unitCircle = new Circle(new Point(0, 0), 1.0)

double getRand() { // returns a value between -1.0 and 1.0
    return rand.nextDouble() * 2.0 - 1.0;
}