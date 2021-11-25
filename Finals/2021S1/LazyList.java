// LazyList
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.lang.IllegalStateException;
import java.util.List;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;
import java.util.Scanner;

/** ******************
    The LazyList abstraction.
    To compile this file, use 'jpp Lazylist.java'
    This will preprocess the macros, and invoke javac
 */
public class LazyList<T> {
    /* An LL consists of a head of type T,
       whose tail is a Thunk of a LazyList<T>
       The flag amIEmpty indicates if this list is empty.
      */
    private final T head;
    private final Thunk(LazyList<T>) tail;
    private final boolean amIEmpty;
    
    /** **************
        Main list constructor. But users should use the macro:
        LLmake(a, b), which is syntactic sugar for:
        new LazyList(a, freeze(b))

        For normal case (ie. without memoization):
        freeze(x) is syntactic sugar for:  (()->(x))
        Thunk(T) is syntactic sugar for:  Supplier<T>

        If memoization is used, then
        freeze(x) is syntactic sugar for: new Memo.make( ()->(x) )
        Thunk(T) is syntactic sugar for Memo<T>
    */
    public LazyList(T a, Thunk(LazyList<T>) b) {
        this.head = a;
        this.tail = b;
        this.amIEmpty = false;
    }

    /** **************
        Private constructor of an empty list.
    */
    private LazyList() {
        this.head = null;
        this.tail = null;
        this.amIEmpty = true;
    }

    /** **************
        Convenience function to thaw a thunk.
    */
    public static <T> T thaw(Thunk(T) ice) {
        return ice.get();
    }
    
    /** **************
        Create an empty LazyList.
    */
    public static <T> LazyList<T> makeEmpty() {
        return new LazyList<T>();
    }
    
    /** **************
        Return the head of this list.
    */
    public T head() {
        if (this.isEmpty())
            throw new IllegalArgumentException("head() called on empty list!");
        
        return this.head;
    }

    /** **************
        Thaw the tail of the list, and return it.
    */
    public LazyList<T> tail() {
        if (this.isEmpty())
            throw new IllegalArgumentException("tail() called on empty list!");
        return thaw(this.tail);
    }

    /** **************
        Return true if this list is empty, false otherwise.
    */
    public boolean isEmpty() {
        return this.amIEmpty;
    }

    /** **************
        Return true if this list equals obj, false otherwise.
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (obj instanceof LazyList) {
            LazyList<?> ll = (LazyList<?>) obj;
            return this.hasSameContent(ll);
        }
        else
            return false;
    }
                          
    /** **************
        Return true if this list is has the same content has other,
        false otherwise.
    */
    public boolean hasSameContent(LazyList<?> other) {
        if (this.isEmpty() && other.isEmpty())
            return true;
        else if (!this.isEmpty() && !other.isEmpty())
            return this.head().equals(other.head()) &&
                this.tail().hasSameContent(other.tail());
        else
            return false;
    }

    
    /** **************
        Return a human-readable string of this list.
    */
    @Override
    public String toString() {
        if (this.isEmpty())
            return "**empty**";
        return String.format("head: %s, tail: thunk!%s",
                             this.head.toString(), this.tail.toString());
    }

    /** **************
        Print all the elements in this list. This thaws all the
        elements. If this list is infinite, then the printing
        could go on forever.
    */
    public void print() {
        LazyList<T> me = this;
        System.out.printf("(* ");
        while (!me.isEmpty()) {
            System.out.printf("%s, ", me.head());
            me = me.tail();
        }
        System.out.println("*)");
    }

    /** **************
        Convenience function to make a LL of multiple arguments.
    */
    @SafeVarargs
    public static <T> LazyList<T> fromList(T ... items) {
        List<T> list = Arrays.asList(items);
        return helper(list);
    }

    private static <T> LazyList<T> helper(List<T> list) {
        if (list.isEmpty())
            return LazyList.makeEmpty();
        else
            return LLmake(list.get(0),
                          helper(list.subList(1,list.size())));
    }

    /** **************
        Apply the mapping function f onto each element of this list,
        and return a new LL containing the mapped elements.
    */
    public <R> LazyList<R> map(Function<T,R> f) {
        System.out.println("map called");
        if (this.isEmpty())
            return LazyList.makeEmpty();
        else
            return LLmake(f.apply(this.head()),
                          this.tail().map(f));
    }

    /** **************
        Apply the mapping function f onto each element of this list, and
        return a new LL containing all the flattened mapped elements.
        Note that f produces a list for each element. But the returned
        LL flattens them all, ie. removes nested lists.
    */
    public <R> LazyList<R> flatmap(Function<T, LazyList<R>> f) {
        if (this.isEmpty())
            return LazyList.makeEmpty();
        else
            return f.apply(this.head())
                .concat(this.tail().flatmap(f));
    }
    
    /** **************
        Return a new LL whose elements (from this list)
        pass the test of the predicate pred.
    */
    public LazyList<T> filter(Predicate<T> pred) {
        System.out.println("filter called");
        if (this.isEmpty())
            return LazyList.makeEmpty();
        else if (pred.test(this.head()))
            return LLmake(this.head(),
                          this.tail().filter(pred));
        else
            return this.tail().filter(pred);
    }

    /** **************
        Return a new LL of length maxSize.
        The new list contains the same elements as this one.
    */
    public LazyList<T> limit(long maxSize) {
        if (maxSize == 0)
            return LazyList.makeEmpty();
        else
            return LLmake(this.head(),
                          this.tail().limit(maxSize - 1));
    }

    /** **************
        Return a new LL whose elements are the combination, element-wise,
        of this and other list. The combination is specified by the 
        BinaryOperator binOp, and thus could be addition, multiplication, etc.
    */
    public LazyList<T> elementWiseCombine(LazyList<T> other,
                                  BinaryOperator<T> binOp) {
        if (this.isEmpty() || other.isEmpty())
            return LazyList.makeEmpty();
        else
            return LLmake(binOp.apply(this.head(), other.head()),
                          this.tail().elementWiseCombine(other.tail(), binOp));
    }

    /** **************
        Return the element at position given by idx.
        idx starts from 0, and should be non-negative.
    */
    public T get(int idx) {
        if (this.isEmpty() || idx < 0)
            return null;
        else if (idx == 0)
            return this.head();
        else
            return this.tail().get(idx - 1);
    }

    /** **************
        Convenience function: return a LazyList<Integer> of integers
        from a (inclusive) to b (exclusive)
    */
    public static LazyList<Integer> intRange(int a, int b) {
        if (a >= b)
            return LazyList.makeEmpty();
        else
            return LLmake(a, intRange(a + 1, b));
    }

    /** **************
        Concatenate other list to this one.
    */
    public LazyList<T> concat(LazyList<T> other) {
        if (this.isEmpty())
            return other;
        else
            return LLmake(this.head(),
                          this.tail().concat(other));
    }
    
    /** **************
        Invoke the consumer eat on every element in this list.
        This is an eager operation: the entire list will be thawed.
    */
    public void forEach(Consumer<T> eat) {
        if (this.isEmpty())
            return;
        else {
            eat.accept(this.head());
            this.tail().forEach(eat);
        }
    }

    /** **************
        Aggregate all the elements in this list, using the accumulator and identity.
        This is an eager operation: the entire list will be thawed.
    */
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        if (this.isEmpty())
            return identity;
        else
            return accumulator.apply(this.head(),
                                     this.tail().reduce(identity,
                                                        accumulator));
    }

    <T> LazyList<LazyList<T>> permute(LazyList<T> LL, int r) {
        if (r == 0)
            return LLmake(LazyList.makeEmpty(), LazyList.makeEmpty());
        else if (LL.isEmpty())
            return LazyList.makeEmpty();
        else
            return LL.flatmap(x ->
                              permute(remove(LL, x), r - 1)
                              .map(y -> LLmake(x,y)));
        }
    
    <T> LazyList<T> remove(LazyList<T> LL, T n) {
        return LL.filter(x-> !x.equals(n));
    }

    <T> LazyList<LazyList<T>> choose(LazyList<T> LL, int r) {
        if (r == 0)
            return LLmake(LazyList.makeEmpty(), LazyList.makeEmpty());
        else if (LL.isEmpty())
            return LazyList.makeEmpty();
        else {
            T h = LL.head();
            LazyList<T> rm = remove(LL, h);
            return choose(rm, r - 1)
                    .map(y -> LLmake(h, y))
                    .concat(choose(rm, r));
        }
    }
}



