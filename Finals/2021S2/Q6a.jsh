/open SecondBest.java

SecondBest<T> add(T t) {
    if (this.cmp.compare(second, t) < 0) {
        return ...
    } else {
        return ...
    }
}

new SecondBest<Integer>(1, 2, (x, y) -> x - y) // 1
new SecondBest<Integer>(1, 2, (x, y) -> x - y).add(3) // 2
new SecondBest<Integer>(1, 2, (x, y) -> x - y).add(3).add(4).add(2) // 3