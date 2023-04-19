class Candle extends Thing {
    private static final String[] STATES = new String[]{
        "Candle flickers.",
        "Candle is getting shorter.",
        "Candle is about to burn out.",
        "Candle has burned out."};

    Candle() {
        super(STATES);
    }
}