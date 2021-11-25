class Triple<T,R,S> {
    T t;
    R r;
    S s;
    Client c;
    
    Triple(T t, R r, S s, Client c) {
        this.t = t;
        this.r = r;
        this.s = s;
        this.c = c;
    }

    T getFirst() {
        return t;
    }

    R getSecond() {
        return r;
    }

    S getThird() {
        return s;
    }

    void print() {
        System.out.println(String.format(
        "%s %s %s", this.t,this.r,this.s));
    }
}