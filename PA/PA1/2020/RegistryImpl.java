class RegistryImpl extends Registry {
    private final String stub;
    private final Token[] tokens;
    private static final int MAX_TOKENS = 20;

    RegistryImpl(String s, Token[] tokens) {
        this.stub = s;
        this.tokens = tokens;
    }

    RegistryImpl(String s) {
        this(s, new Token[MAX_TOKENS]);
    }

    @Override
    void alert(int t) {
        for (Token token : tokens) {
            if (token != null) {
                String[] pingSplit = token.getPings();
                int[] pingTime = new int[MAX_TOKENS];
                for (int i = 0; i < MAX_TOKENS; i++) {
                    if (pingSplit[i] != null) {
                        pingTime[i] = Integer.parseInt(pingSplit[i].split("@")[1]);
                    }
                }

                String[] newPings = new String[MAX_TOKENS];
                for (int j = 0; j < MAX_TOKENS; j++) {
                    if (pingTime[j] == t) {
                        newPings[j] = pingSplit[j];
                    }
                }


                if (token.isSafeEntry()) {
                    if (token.getTime() == t) {
                        super.store(new SafeEntry(token.getId(), t).toString());
                    } else {
                        super.store(new SafeEntry(token.getId(), -1).toString());
                    }
                } else {
                    super.store(new Token(token.getId(), newPings).toString());
                }
            }
        }
    }

    RegistryImpl add(Token tok) {
        int idx = 0;
        Token[] newTokens = new Token[MAX_TOKENS];
        for (Token t: this.tokens) {
            if (t != null) {
                newTokens[idx] = t;
                idx++;
            }
        }
        newTokens[idx++] = tok;
        return new RegistryImpl(this.stub, newTokens);
    }

    int numRegistered() {
        int ans = 0;
        for (Token t: this.tokens) {
            if (t != null) {
                ans++;
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        String tokenString = "";
        for (Token t : this.tokens) {
            if (t != null) {
                tokenString += "\n" + t.toString();
            }
        }
        return "[" + this.stub + "]: " + this.numRegistered() + 
                " tokens registered" + tokenString;
    }    
}
