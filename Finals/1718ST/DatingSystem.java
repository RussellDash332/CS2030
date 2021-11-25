import java.util.List;
import java.util.ArrayList;

public class DatingSystem {    
    public static void main(String[] args) {
        int men = 0;
        int women = 0;
        int rels = 0;
        
        Man mickey = new Man("Mickey");
        Man donald = new Man("Donald");
        Man goofy = new Man("Goofy");
        Woman daisy = new Woman("Daisy");
        Woman minnie = new Woman("Minnie");

        mickey = mickey.date(minnie);
        donald = donald.date(goofy);
        daisy = daisy.date(donald);

        List<Person> people = List.of(mickey, donald, goofy, daisy, minnie);
        List<Person> inRelationship = new ArrayList<Person>();
        String fin = "";

        for (Person p : people) {
            if (p.isMan()) {
                men++;
            } else {
                women++;
            }
            if (p.isDater()) {
                rels++;
                fin += "\n" + p;
                inRelationship.add(p);
                inRelationship.add(p.getPair()[0]);
            }
        }

        for (Person p : people) {
            if (!inRelationship.contains(p)) {
                fin += "\n" + p + " is not in a relationship";
            }
        }

        System.out.println("Number of relationships: " + rels);
        System.out.println("Number of men: " + men);
        System.out.println("Number of women: " + women);
        System.out.println(fin);

    }
}