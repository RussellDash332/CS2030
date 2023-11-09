SumList sumlist = new SumList(List.of(1, 2, 3, 4, 5))
sumlist instanceof DnC
sumlist.solve((x,y) -> x + y)
sumlist.left().solve((x,y) -> x + y)
sumlist.right().solve((x,y) -> x + y)
sumlist.right().right().solve((x,y) -> x + y)
sumlist.right().right().right().solve((x,y) -> x + y)