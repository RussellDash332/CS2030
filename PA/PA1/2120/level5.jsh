Case c = new Case(new Person("A123", "PP", 8), new PCR("omicron"))
new ContactCase(new Person("B234", "M", 7), new ART("CT"), c)
Test t = new ART("C")
Case d = new ContactCase(new Person("B234", "M", 7), t, c)
Protocol p = d.getCurrentProtocol()
p instanceof P3
d = d.test(t)
d = d.test(t)
d = d.test(t)
d = d.test(t)
d = d.test(t)
d = d.test(t)
d = d.test(new PCR("delta"))
void printLineage(ImList<Case> lineage) {
    boolean first = true;
    for (Case c : lineage) {
        System.out.println((first ? "" : "-> ") + c);
        first = false;
    }
}
printLineage(c.getLineage())
printLineage(d.getLineage()) // c -> d
ContactCase e = new ContactCase(new Person("C345", "", 10), new ART("CT"), d)
printLineage(e.getLineage()) // c -> d -> e