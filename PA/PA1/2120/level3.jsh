interface Protocol {
    Protocol next(Person person, Test test); // generates the next protocol
}

new Case(new Person("A123", "PP", 8), new ART("C"))
Case c = new Case(new Person("A123", "PP", 8), new PCR("alpha"))
Protocol p = c.getCurrentProtocol()
p instanceof P1
c = c.test(new PCR("beta"))
c = c.test(new ART("T")) // invalid test not recorded
c = c.test(new ART("CT"))
c = c.test(new ART("C"))
c = c.test(new ART("C"))
c = c.test(new ART("CT"))
c = c.test(new ART("C"))
c.getTestHistory()
c.getTestHistory() instanceof ImList