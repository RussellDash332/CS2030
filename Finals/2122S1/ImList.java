import java.util.List;
import java.util.ArrayList;
class ImList<T> {
    private final List<T> list;
    ImList() {
        this.list = new ArrayList<T>();
    }
    private ImList(List<T> oldList) {
        this.list = new ArrayList<T>(oldList);
    }
    ImList<T> add(T elem) {
        ImList<T> newList = new ImList<T>(this.list);
        newList.list.add(elem);
        return newList;
    }
    ImList<T> set(int index, T elem) {
        ImList<T> newList = new ImList<T>(this.list);
        newList.list.set(index, elem);
        return newList;
    }
    // other methods omitted for brevity
}
