class Instructor {
    private final String name;

    Instructor(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Instructor) {
            return this.name.equals(((Instructor) other).name);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
