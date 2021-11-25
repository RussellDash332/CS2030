class Circle {
    private final int radius;
    
    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals(Object) called");
        if (obj == this) {
            return true;
        } else if (obj instanceof Circle) {
            Circle circle = (Circle) obj;
            return circle.radius == radius;
        } else {
            return false;
        }
    }
    
    boolean equals(Circle circle) {
        System.out.println("equals(Circle) called");
        return circle.radius == radius;
    }
}    
