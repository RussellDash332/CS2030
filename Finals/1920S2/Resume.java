import java.util.Optional;
import java.util.ArrayList;

class Resume {
    private String s;
    
    Resume(String s) {
        this.s = s;
    }

    Optional<ArrayList<String>> getListOfLanguages() {
        ArrayList<String> list = new ArrayList<String>();
        if (s == "Test") {
            list.add("Test");
            return Optional.<ArrayList<String>>of(list);
        } else if (s == "Java") {
            list.add("Java");
            return Optional.<ArrayList<String>>of(list);
        }
        return Optional.empty();
    }
}