Stream.<Seat>of(new Available(), new Booked()).map(x -> x.isBooked()).toList()
Stream.<Seat>of(new Available(), new Booked()).forEach(x -> System.out.println(x))
