class Thing {
    private final String[] status;
    private final int timestamp;

    Thing(String[] status) {
        this(status, 0);
    }

    private Thing(String[] status, int timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }

    Thing age() {
        if (this.timestamp < this.status.length - 1) {
            return new Thing(this.status, this.timestamp + 1);
        } else {
            return this;
        }
    }

    boolean isSword() {
        return this.toString().contains("Sword");
    }

    boolean isTroll() {
        return this.toString().contains("Troll");
    }

    @Override
    public String toString() {
        return this.status[this.timestamp];
    }
}