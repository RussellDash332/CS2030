import java.util.List;
import java.util.ArrayList;

class ImList<T> {
    private final List<T> list;
    
    ImList() {
        this.list = new ArrayList<T>();
    }
    
    private ImList(List<? extends T> list) {
        this.list = new ArrayList<T>(list);
    }
    
    ImList<T> add(T t) {
        System.out.println("Adding: " + t);
        ImList<T> newList = new ImList<T>(this.list);
        newList.list.add(t);
        return newList;
    }
    
    ImList<T> set(int index, T t) {
        System.out.println("Setting: " + index + ", " + t);
        ImList<T> newList = new ImList<T>(this.list);
        newList.list.set(index, t);
        return newList;
    }
    
    T get(int index) {
        return this.list.get(index);
    }
    
    @Override
    public String toString() {
        return "ImList";
    }
}
