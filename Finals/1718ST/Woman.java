class Woman extends Person {
    Woman(String name) {
        super(name);
    }

    Woman(String name, Person pair) {
        super(name, pair);
    }

    Woman date(Person p) {
        p.getPair()[0] = null;
        return new Woman(this.getName(), p);
    }

    @Override
    boolean isMan() {
        return false;
    }
}