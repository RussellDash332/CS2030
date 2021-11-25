public class Box {
    private String value = "";
    
    private Box(String s) {
        value = s.toUpperCase();
    }

    public static Box of(String input) {
        return new Box(Objects.requireNonNull(input));
    }

    public Box map(Function<String, String> f) {
        return new Box(f.apply(this.value));
    }

    @Override
    public String toString() {
        return value;
    }
}