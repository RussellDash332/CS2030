interface Shape3D {
    double getVolume();
}

interface Solid3D extends Shape3D {
    double getMass();    
}

class Sphere implements Shape3D {
    private final double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    public double getVolume() {
        return (4.0 / 3) * Math.PI * radius * radius * radius;
    }
}

class Solid {
    private final double density;

    Solid(double density) {
        this.density = density;
    }

    double getMass(double volume) {
        return this.density * volume;
    }
}

class SolidSphere extends Sphere implements Solid3D {
    private final Solid solid;

    SolidSphere(double r, double density) {
        super(r);
        this.solid = new Solid(density);
    }

    public double getMass() {
        return this.solid.getMass(super.getVolume());
    }
}

class Cuboid implements Shape3D {
    private final double length;
    private final double width;
    private final double height;

    Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getVolume() {
        return this.length * this.width * this.height;
    }
}

class SolidCuboid extends Cuboid {
    private final Solid solid;

    SolidCuboid(double length, double width, double height, double density) {
        super(length, width, height);
        this.solid = new Solid(density);
    }

    public double getMass() {
        return this.solid.getMass(super.getVolume());
    }
}
