<T, U, R> Stream<R> product(
        List<? extends T> list1,
        List<? extends U> list2,
        BiFunction<? super T, ? super U, ? extends R> func) {
    return list1.stream()
        .flatMap(x -> list2.stream()
                .map(y -> func.apply(x,y)));
}
