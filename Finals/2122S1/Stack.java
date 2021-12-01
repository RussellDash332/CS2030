import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
class Stack<T> {
    private final List<T> list;
    Stack() {
        this.list = new ArrayList<T>();
    }
    private Stack(List<T> oldList) {
        this.list = new ArrayList<T>(oldList);
    }
    Stack<T> push(T elem) {
        Stack<T> newStack = new Stack<T>(this.list);
        newStack.list.add(0, elem);
        return newStack;
    }
    boolean isEmpty() {
        return this.list.isEmpty();
    }
    public String toString() {
        return "Top -> " + this.list;
    }
}
