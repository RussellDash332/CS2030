












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






public class LazyList<T> {




    private final T head;
    private final Supplier<LazyList<T> > tail;
    private final boolean amIEmpty;

    public LazyList(T a, Supplier<LazyList<T> > b) {
        this.head = a;
        this.tail = b;
        this.amIEmpty = false;
    }




    private LazyList() {
        this.head = null;
        this.tail = null;
        this.amIEmpty = true;
    }




    public static <T> T thaw(Supplier<T> ice) {
        return ice.get();
    }




    public static <T> LazyList<T> makeEmpty() {
        return new LazyList<T>();
    }




    public T head() {
        if (this.isEmpty())
            throw new IllegalArgumentException("head() called on empty list!");

        return this.head;
    }




    public LazyList<T> tail() {
        if (this.isEmpty())
            throw new IllegalArgumentException("tail() called on empty list!");
        return thaw(this.tail);
    }




    public boolean isEmpty() {
        return this.amIEmpty;
    }




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





    public boolean hasSameContent(LazyList<?> other) {
        if (this.isEmpty() && other.isEmpty())
            return true;
        else if (!this.isEmpty() && !other.isEmpty())
            return this.head().equals(other.head()) &&
                this.tail().hasSameContent(other.tail());
        else
            return false;
    }





    @Override
    public String toString() {
        if (this.isEmpty())
            return "**empty**";
        return String.format("head: %s, tail: thunk!%s",
                             this.head.toString(), this.tail.toString());
    }






    public void print() {
        LazyList<T> me = this;
        System.out.printf("(* ");
        while (!me.isEmpty()) {
            System.out.printf("%s, ", me.head());
            me = me.tail();
        }
        System.out.println("*)");
    }




    @SafeVarargs
    public static <T> LazyList<T> fromList(T ... items) {
        List<T> list = Arrays.asList(items);
        return helper(list);
    }

    private static <T> LazyList<T> helper(List<T> list) {
        if (list.isEmpty())
            return LazyList.makeEmpty();
        else
            return new LazyList<>((list.get(0)), ( ()->(helper(list.subList(1,list.size()))) ))
                                                              ;
    }





    public <R> LazyList<R> map(Function<T,R> f) {
        System.out.println("map called");
        if (this.isEmpty())
            return LazyList.makeEmpty();
        else
            return new LazyList<>((f.apply(this.head())), ( ()->(this.tail().map(f)) ))
                                             ;
    }







    public <R> LazyList<R> flatmap(Function<T, LazyList<R>> f) {
        if (this.isEmpty())
            return LazyList.makeEmpty();
        else
            return f.apply(this.head())
                .concat(this.tail().flatmap(f));
    }





    public LazyList<T> filter(Predicate<T> pred) {
        System.out.println("filter called");
        if (this.isEmpty())
            return LazyList.makeEmpty();
        else if (pred.test(this.head()))
            return new LazyList<>((this.head()), ( ()->(this.tail().filter(pred)) ))
                                                   ;
        else
            return this.tail().filter(pred);
    }





    public LazyList<T> limit(long maxSize) {
        if (maxSize == 0)
            return LazyList.makeEmpty();
        else
            return new LazyList<>((this.head()), ( ()->(this.tail().limit(maxSize - 1)) ))
                                                         ;
    }






    public LazyList<T> elementWiseCombine(LazyList<T> other,
                                  BinaryOperator<T> binOp) {
        if (this.isEmpty() || other.isEmpty())
            return LazyList.makeEmpty();
        else
            return new LazyList<>((binOp.apply(this.head(), other.head())), ( ()->(this.tail().elementWiseCombine(other.tail(), binOp)) ))
                                                                              ;
    }





    public T get(int idx) {
        if (this.isEmpty() || idx < 0)
            return null;
        else if (idx == 0)
            return this.head();
        else
            return this.tail().get(idx - 1);
    }





    public static LazyList<Integer> intRange(int a, int b) {
        if (a >= b)
            return LazyList.makeEmpty();
        else
            return new LazyList<>((a), ( ()->(intRange(a + 1, b)) ));
    }




    public LazyList<T> concat(LazyList<T> other) {
        if (this.isEmpty())
            return other;
        else
            return new LazyList<>((this.head()), ( ()->(this.tail().concat(other)) ))
                                                    ;
    }





    public void forEach(Consumer<T> eat) {
        if (this.isEmpty())
            return;
        else {
            eat.accept(this.head());
            this.tail().forEach(eat);
        }
    }





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
            return new LazyList<>((LazyList.makeEmpty()), ( ()->(LazyList.makeEmpty()) ));
        else if (LL.isEmpty())
            return LazyList.makeEmpty();
        else
            return LL.flatmap(x ->
                              permute(remove(LL, x), r - 1)
                              .map(y -> new LazyList<>((x), ( ()->(y) ))));
        }

    <T> LazyList<T> remove(LazyList<T> LL, T n) {
        return LL.filter(x-> !x.equals(n));
    }

    <T> LazyList<LazyList<T>> choose(LazyList<T> LL, int r) {
        if (r == 0)
            return new LazyList<>((LazyList.makeEmpty()), ( ()->(LazyList.makeEmpty()) ));
        else if (LL.isEmpty())
            return LazyList.makeEmpty();
        else {
            T h = LL.head();
            LazyList<T> rm = remove(LL, h);
            return choose(rm, r - 1)
                    .map(y -> new LazyList<>((h), ( ()->(y) )))
                    .concat(choose(rm, r));
        }
    }
}
