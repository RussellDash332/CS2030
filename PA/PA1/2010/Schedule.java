import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Schedule implements Iterable<Class> {
    private final List<Class> schedule;

    @Override
    public Iterator<Class> iterator() {
        return this.schedule.iterator();
    }

    Schedule() {
        this.schedule = new ArrayList<Class>();
    }

    private Schedule(List<Class> cList) {
        this.schedule = cList;
    }

    Schedule add(Class newClass) {
        List<Class> newList = new ArrayList<Class>();
        boolean noClash = true;

        for (Class c : this.schedule) {
            newList.add(c);
            if (newClass.clashWith(c)) {
                noClash = false;
            }
        }

        if (noClash) {
            newList.add(newClass);
        }
        newList.sort(null);
        return new Schedule(newList);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.schedule.size() - 1; i++) {
            result += this.schedule.get(i) + "\n";
        }
        result += this.schedule.get(this.schedule.size() - 1);

        return result;
    }
}
