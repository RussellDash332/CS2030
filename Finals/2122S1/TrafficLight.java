class TrafficLight {
    private final String color;
    TrafficLight(String color) {
        this.color = color;
    }
    TrafficLight toggle() {
        if (this.color.equals("red")) {
            return new TrafficLight("green");
        } else {
            return new TrafficLight("red");
        }
    }
    @Override
    public String toString() {
        return this.color;
    }
}
