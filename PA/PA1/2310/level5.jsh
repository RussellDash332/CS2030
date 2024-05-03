StagedFare sfare = new StagedFare(7000, 110).add(4000, 90)
RebateFare rfare = new RebateFare(sfare, 25)
Trip trip = new Trip(new Train(1, 5))
trip.fare(rfare)
trip.next(new Bus("96A", 4, 7)).fare(rfare)
DistanceFare dfare = new DistanceFare(91, 3200, 10, 1000, 40200)
Trip trip = new Trip(new Train(1, 5))
trip.fare(dfare)
trip.next(new Bus("96A", 4, 7)).fare(dfare)
StagedFare sfare = new StagedFare(7000, 110).add(4000, 90)
RebateFare rfare = new RebateFare(sfare, 25)
System.out.println("Error expected below:")
new RebateFare(dfare, 25)
System.out.println("Error expected below:")
new RebateFare(rfare, 25)
Fare fare = sfare
Fare fare = rfare
Fare fare = dfare