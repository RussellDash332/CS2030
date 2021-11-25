abstract class O {
    private Object other;
    
    void set(Object other) {
        this.other = other;
    }

    Object get() {
        return this.other;
    }
}

class A extends O {}
class B extends O {}
class C extends O {}