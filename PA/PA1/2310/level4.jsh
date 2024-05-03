new StagedFare(4000, 90)
new StagedFare(4000, 90).add(7000, 110)
new StagedFare(7000, 110).add(4000, 90)
StagedFare sfare = new StagedFare(7000, 110).add(4000, 90)
Fare fare = sfare
Trip trip = new Trip(new Train(1, 5))
trip.fare(sfare)
trip.next(new Bus("96A", 4, 7)).fare(sfare)