List<Integer> list = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19)
List<Integer> result = new ArrayList<>()
list.stream().parallel().
filter(x -> x % 2 == 1).
forEach(x -> result.add(x)) // what is result?
/exit