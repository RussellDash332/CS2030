class Troll extends Thing {
    private static final String[] STATES = new String[]{
        "Troll lurks in the shadows.",
        "Troll is getting hungry.",
        "Troll is VERY hungry.",
        "Troll is SUPER HUNGRY and is about to ATTACK!",
        "Troll attacks!"};

    Troll() {
        super(STATES);
    }
}