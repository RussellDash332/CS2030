Train train = new Train(1, 2)
train.distance()
train = new Train(1, 3)
train.distance()
Ride ride = train
Trip trip = new Trip(train)
trip.next(new Bus("96A", 4, 7))
trip.next(new Train(3, 5))
trip.next(new Train(3, 5)).next(new Bus("96A", 4, 7)).next(new Bus("96A", 6, 10))