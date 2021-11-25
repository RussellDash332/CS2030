import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;

class Room {
    private final String name;
    private final List<Thing> objects;
    private final boolean swordTaken;
    private final List<Room> prev;

    Room(String name) {
        this(name, new ArrayList<Thing>(), false, new ArrayList<Room>());
    }

    Room(String name, Room r) {
        this(name, r.getThings(), r.swordIsTaken(), r.getPrev());
    }

    Room(String name, List<Thing> objects, boolean swordTaken, List<Room> prev) {
        this.name = name;
        this.objects = objects;
        this.swordTaken = swordTaken;
        this.prev = prev;
    }

    Room add(Thing newT) {
        List<Thing> newObjects = new ArrayList<Thing>();
        for (Thing t : this.objects) {
            newObjects.add(t);
        }
        newObjects.add(newT);
        return new Room(this.name, newObjects, this.swordIsTaken(), this.getPrev());
    }

    Room tick() {
        List<Thing> newObjects = new ArrayList<Thing>();
        for (Thing t : this.objects) {
            newObjects.add(t.age());
        }
        return new Room(this.name, newObjects, this.swordIsTaken(), this.getPrev());
    }

    Room tick(Function<Room, Room> f) {
        Room r = f.apply(this);
        if (this == r) {
            return this.tick();
        }
        return r;
    }

    Room go(Function<Room, Room> f) {
        Room r = f.apply(this);
        List<Room> newPrev = new ArrayList<Room>();
        for (Room r2 : this.getPrev()) {
            newPrev.add(r2);
        }
        newPrev.add(this);
        if (this.swordIsTaken() && !r.containsSword()) {
            List<Thing> newThings = new ArrayList<Thing>();
            newThings.add(new Sword());
            newThings.addAll(r.getThings());
            return new Room(r.getName(), newThings, true, newPrev);
        }
        return new Room(r.getName(), r.getThings(), r.swordIsTaken(), newPrev);
    }

    Room back() {
        if (this.getPrev().isEmpty()) {
            System.out.println("Dummy statement reached");
            return this.tick(); // dummy
        } else {
            Room r = this.getPrev().get(this.getPrev().size() - 1);
            List<Room> newPrev = new ArrayList<Room>();
            // Or instead take from r.getPrev()
            for (int i = 0; i < this.getPrev().size() - 1; i++) {
                newPrev.add(this.getPrev().get(i));
            }
            if (this.swordIsTaken() && !r.containsSword()) {
                List<Thing> newThings = new ArrayList<Thing>();
                newThings.add(new Sword());
                newThings.addAll(r.getThings());
                return new Room(r.getName(), newThings, true, newPrev).tick();
            }
            return new Room(r.getName(), r.getThings(), r.swordIsTaken(), newPrev).tick();
        }
    }

    boolean containsSword() {
        for (Thing t : this.objects) {
            if (t.isSword()) {
                return true;
            }
        }
        return false;
    }

    boolean containsTroll() {
        for (Thing t : this.objects) {
            if (t.isTroll()) {
                return true;
            }
        }
        return false;
    }

    String getName() {
        return this.name;
    }

    List<Thing> getThings() {
        return this.objects;
    }

    boolean swordIsTaken() {
        return this.swordTaken;
    }

    List<Room> getPrev() {
        return this.prev;
    }

    @Override
    public String toString() {
        String out = "@" + this.name;
        for (Thing t : this.objects) {
            out += "\n" + t.toString();
        }
        return out;
    }
}