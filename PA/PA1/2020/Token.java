class Token {
    private final int id;
    private final String[] pings;
    private static final int MAX_TOKENS = 20;

    Token(int id) {
        this(id, new String[MAX_TOKENS]);
    }

    public int getId() {
        return this.id;
    }

    public String[] getPings() {
        return this.pings;
    }

    Token(int id, String[] pings) {
        this.id = id;
        this.pings = pings;
    }

    boolean isSafeEntry() {
        return false;
    }

    public int getTime() {
        return -1;
    }

    Token ping(Token tk, int t) {
        String[] newPings = new String[MAX_TOKENS];
        for (int i = 0; i < MAX_TOKENS; i++) {
            newPings[i] = this.pings[i];
        }
        newPings[tk.getId() - 1] = "#" + tk.getId() + "@" + t;
        return new Token(this.id, newPings);
    }

    @Override
    public String toString() {
        String result = "Token #" + this.id + ":";
        boolean havePing = false;
        for (String s : this.pings) {
            if (s != null) {
                result += " " + s;
                havePing = true;
            }
        }
        return result + (havePing ? "" : " none");
    }
}
