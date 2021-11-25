BiFunction<Character,String,Integer> s = new BiFunction<Character,String,Integer>(){
    public Integer apply(Character i, String j) {
        return (i + j).length();
    }
}

BiFunction<Double,Float,Long> r = new BiFunction<Double,Float,Long>(){
    public Long apply(Double a, Float b) {
        return Math.round(a + b);
    }
}

BiFunction<String,Integer,String> c = new BiFunction<String,Integer,String>(){
    public String apply(String x, Integer y) {
        return String.format("%s:%d", x, y);
    }
}

s.apply('A', "PPLE");
r.apply(1.0, new Float(3.14));
c.apply("Hello", 23);
