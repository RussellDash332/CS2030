List<?> list = new ArrayList<String>();
list.add("abc");

List<? super Integer> list = new ArrayList<Object>();
list.add(new Object())

List<? extends Object> list = new ArrayList<Object>()
list.add(new Object())

List<? extends Object> list = List.<String>of("abc");
list.add("def");
String s = list.get(0);

List<? super Integer> list = new ArrayList<int>();

List<? super Integer> list = new ArrayList();
