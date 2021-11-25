class SafeEntry extends Token {
    private final int time;

    SafeEntry(int id, int time) {
        super(id); 
        this.time = time;
    }

    @Override
    boolean isSafeEntry() {
        return true;
    }

    @Override
    public int getTime() {
        return this.time;
    }

    @Override 
    public String toString() {
        if (this.time != -1) {
            return "SafeEntry #" + this.getId() + "@" + this.time;
        } else {
            return "SafeEntry #" + this.getId() + ": none";
        }
    }
}
