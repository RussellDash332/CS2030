Function<Room, Room> takeSword = r -> {
    if (r.swordIsTaken()) {
        System.out.println("--> You already have sword.");
        return r.tick();
    } else if (r.containsSword()) {
        System.out.println("--> You have taken sword.");
        return new Room(r.getName(), r.getThings(), true, r.getPrev()).tick();
    } else {
        System.out.println("--> There is no sword.");
        return r.tick();
    }
}

Function<Room, Room> killTroll = r -> {
    if (!r.containsTroll()) {
        System.out.println("--> There is no troll");
        return r.tick();
    } else if (r.swordIsTaken()) { // has troll and taken sword
        System.out.println("--> Troll is killed.");
        List<Thing> newThings = new ArrayList<Thing>();
        for (Thing t : r.getThings()) {
            if (!t.isTroll()) {
                newThings.add(t);
            }
        }
        return new Room(r.getName(), newThings, true, r.getPrev()).tick();
    } else { // has troll but not taken sword
        System.out.println("--> You have no sword.");
        return r.tick();
    }
}

Function<Room, Room> dropSword = r -> {
    if (r.swordIsTaken()) {
        System.out.println("--> You have dropped sword.");
        return new Room(r.getName(), r.getThings(), false, r.getPrev()).tick();
    } else {
        return r.tick(); // dummy
    }
}