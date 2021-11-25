import java.util.List;
import java.util.ArrayList;

class Async {
    private final Thread thread;
    private final List<Runnable> callbacks;
    
    private Async(Runnable r) {
        this.thread = new Thread(r);
        this.callbacks = new ArrayList<Runnable>();
        thread.start();
    }
    
    static Async doThis(Runnable r) {
        return new Async(r);
    }
    
    Async thenDoThis(Runnable callback) {
        this.callbacks.add(callback);
        return this;
    }
    
    void join() {
        try {
            this.thread.join();
        } catch (InterruptedException e) { }
        for (Runnable r : this.callbacks) {
            r.run();
        }
    }
}