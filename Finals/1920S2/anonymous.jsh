BiFunction<Character,String,Integer> s = new BiFunction<Character,String,Integer>() {
    public Integer apply(Character i, String j) {
        return (i + j).length();
    }
}