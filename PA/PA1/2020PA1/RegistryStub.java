class RegistryStub extends Registry {
    private final String stub;

    RegistryStub(String s) {
        this.stub = s;
    }

    RegistryStub() {
        this.stub = "";
    }

    @Override
    public String toString() {
        return "[" + this.stub + "]";
    }
}
