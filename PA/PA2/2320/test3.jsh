StateM.<String, Integer>unit("init").flatMap(x -> StateM.<Integer, Integer>unit(x.length()))
StateM.<String, Integer>unit("init").flatMap(x -> StateM.<Integer, Integer>unit(x.length())).accept(0)
Function<Integer, StateM<Integer, String>> id = x -> StateM.<Integer, String>unit(x)
Function<Integer, StateM<Integer, String>> f = x -> StateM.<Integer, String>unit(x + 1)
f.apply(1).accept("initState")
id.apply(1).flatMap(f).accept("initState")
f.apply(1).flatMap(id).accept("initState")
StateM.<Integer, String>unit(1).flatMap(f).flatMap(f).accept("initState")
StateM.<Integer, String>unit(1).flatMap(x -> f.apply(x).flatMap(f)).accept("initState")
StateM<Integer, Integer> bar(StateM<String, Integer> sm) {
    return sm.flatMap(x -> StateM.<Integer>get().flatMap(y -> StateM.<Integer>put(y + 10)).flatMap(z -> StateM.<Integer, Integer>unit(x.length())));
}
bar(StateM.<String, Integer>unit("init")).accept(1)
Function<String, StateM<Integer, String>> f = s -> {
    return StateM.<String>get().flatMap(x -> StateM.<String>put(x + "f")).flatMap(y -> StateM.<Integer, String>unit(s.length()));
}
Function<Integer, StateM<Integer, String>> g = x -> {
    return StateM.<String>get().flatMap(y -> StateM.<String>put(y + "g")).flatMap(z -> StateM.<Integer, String>unit(2 * x));
}
StateM.<String, String>unit("abc").flatMap(f).flatMap(g).accept("")