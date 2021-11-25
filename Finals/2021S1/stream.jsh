int count(List<String> words) {
    return words.stream()
    .map(x -> x.length())
    .reduce(0, (x,y) -> x+y);
}

int count(List<String> words) {
    return words.stream()
    .reduce(0, (x,y) -> x+y.length(), (x,y) -> x+y);
}