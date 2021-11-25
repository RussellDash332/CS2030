class Main4 {
    static Compute<Long> sum(long n, long s) {
        if (n == 0) {
            return new Base<>(() -> s);
        } else {
            return new Recursive<>(() -> sum(n - 1, n + s));
        }
    }

    public static void main(String[] args) {
        Compute<Long> s = sum(10000, 0);
        while (s.isRecursive()) {
            s = s.recurse();
        }
        System.out.println(s.eval());
    }
}