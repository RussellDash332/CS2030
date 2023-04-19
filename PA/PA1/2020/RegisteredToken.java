class RegisteredToken extends Token {
    private final Registry registry;

    RegisteredToken(Token t, Registry r) {
        super(t.getId(), t.getPings());
        this.registry = r;
    }

    void contact() {
        new DataStore().write("Test contact");
    }
}
