class Man extends Person {
    Man(String name) {
        super(name);
    }

    Man(String name, Person pair) {
        super(name, pair);
    }

    Man date(Person p) {
        p.getPair()[0] = null;
        return new Man(this.getName(), p);
    }
}