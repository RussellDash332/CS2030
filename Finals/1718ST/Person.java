class Person {
    private final String name;
    private final Person[] pair;

    Person(String name) {
        this(name, null);
    }

    Person(String name, Person pair) {
        this.name = name;
        this.pair = new Person[]{pair};
    }

    public String getName() {
        return this.name;
    }

    public Person[] getPair() {
        return this.pair;
    }

    boolean isDater() {
        return this.pair[0] != null;
    }

    boolean isMan() {
        return true;
    }

    @Override
    public String toString() {
        return this.name + (this.isMan() ? "(M)" : "(W)") +
                (this.isDater() ? " and " + this.pair[0].toString() +
                " are in a relationship" : "");
    }
}