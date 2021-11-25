import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BiFunction;

class ImList<T> { // scope of T is within the class
    private final List<T> list;

    ImList() {
        this.list = new ArrayList<T>();
    }

    private ImList(List<T> oldList) {
        this.list = new ArrayList<T>(oldList);
    }

    static <U> ImList<U> of(U[] arr) { // scope of U is within the method
        ImList<U> newList = new ImList<U>();
        for (U u : arr) {
            newList.list.add(u);
        }
        return newList;
    }

    ImList<T> add(T elem) { // add elem to the back
        ImList<T> newList = new ImList<T>(this.list);
        newList.list.add(elem);
        return newList;
    }

    ImList<T> set(int index, T elem) { // set element at index to elem 
        ImList<T> newList = new ImList<T>(this.list);
        newList.list.set(index, elem);
        return newList;
    }

    ImList<T> remove(int index) { // remove element at index
        ImList<T> newList = new ImList<T>(this.list);
        newList.list.remove(index);
        return newList;
    }

    ImList<T> remove(Object obj) { // remove first occurrence of obj
        ImList<T> newList = new ImList<T>(this.list);
        newList.list.remove(obj);
        return newList;
    }

    ImList<T> sort(Comparator<? super T> cmp) {
        ImList<T> newList = new ImList<T>(this.list);
        newList.list.sort(cmp);
        return newList;
    }

    ImList<T> filter(Predicate<? super T> pred) {
        ImList<T> newList = new ImList<T>();
        for (T t : this.list) {
            if (pred.test(t)) {
                newList.list.add(t);
            }
        }
        return newList;
    }

    <R> ImList<R> map(Function<? super T, ? extends R> mapper) {
        ImList<R> newList = new ImList<R>();
        for (T t : this.list) {
            newList.list.add(mapper.apply(t));
        }
        return newList;
    }

    <U> U reduce(U seed, BiFunction<? super U,T,? extends U> mapper) {
        for (T t : this.list) {
            seed = mapper.apply(seed, t);
        }
        return seed;
    }

    ImList<T> addAll(ImList<? extends T> otherList) {
        ImList<T> newList = new ImList<T>(this.list);
        newList.list.addAll(otherList.list);
        return newList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof ImList) {
            ImList<?> otherlist = (ImList<?>) obj;// ? is not a type!
            if (this.list.size() != otherlist.list.size()) {
                return false;
            } else {
                for (int i = 0; i < this.list.size(); i++) {
                    if (!otherlist.list.get(i).equals(this.list.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.list.toString();
    }
}