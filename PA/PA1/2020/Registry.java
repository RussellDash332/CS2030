class Registry {
    /*
    private final String stub;
    private final Token[] tokens;
    private static final int MAX_TOKENS = 20;

    Registry(String s, Token[] t) {
        this.stub = s;
        this.tokens = t;
    }

    Registry(String s) {
        this(s, new Token[MAX_TOKENS]);
    }

    Registry() {
        this("");
    }
    */

    void store(String s) {
        new DataStore().write(s);
    }

    void alert(int t) {}

    Registry add(Token t) {
        return this;
    }
    
    /*
    void alert(int t) {
        for (Token token : this.tokens) {
            if (token != null) {
                String[] pingSplit = token.getPings();
                int[] pingTime = new int[MAX_TOKENS];
                for (int i = 0; i < MAX_TOKENS; i++) {
                    if (pingSplit[i] != null)
                        pingTime[i] = Integer.parseInt(pingSplit[i].split("@")[1]);
                }

                String[] newPings = new String[MAX_TOKENS];
                for (int j = 0; j < MAX_TOKENS; j++) {
                    if (pingTime[j] == t) {
                        newPings[j] = pingSplit[j];
                    }
                }

                this.store((new Token(token.getId(), newPings)).toString());
            }
        }
    }

    Registry add(Token tok) {
        Token[] newTokens = new Token[MAX_TOKENS];
        for (Token t: this.tokens) {
            if (t != null) {
                newTokens[t.getId()] = t;
            }
        }
        newTokens[tok.getId()] = tok;
        return new Registry(this.stub, newTokens);
    }
    */
}
