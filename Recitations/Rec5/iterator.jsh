List<Point> list = new ArrayList<Point>();
list.add(new Point(1, 1));
list.add(new Point(2, 2));
Iterator<Point> iter = list.iterator();
while (iter.hasNext()) {
    System.out.println(iter.next());
}