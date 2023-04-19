interface Protocol {
    Protocol next(Person person, Test test, int numOfDays);
}

new Case(new Person("B234", "M", 7), new PCR("decepticon"))
Case c = new Case(new Person("B234", "M", 7), new PCR("delta"))
Protocol p = c.getCurrentProtocol()
p instanceof P2
c.test(new PCR("zero"))
c = c.test(new PCR("zero")).test(new ART("C"))
c.test(new ART("C")) // discharged after 72 hours (or 3 days)
c.test(new ART("C")).test(new ART("C"))
c.test(new PCR("beta"))
c.test(new PCR("beta")).test(new PCR("ok"))
Test pt = new ART("CT")
Case c = new Case(new Person("C345", "MM", 7), new PCR("delta"))
c = c.test(pt)
c = c.test(pt)
c = c.test(pt)
c = c.test(pt)
c = c.test(new ART("T")) // invalid test
c = c.test(pt)
c = c.test(pt)
c = c.test(pt) // Discharged after 7-days even if tested positive
c = c.test(new ART("C"))
c.test(pt)
c.test(pt).test(pt)
c.test(pt).test(pt).test(new ART("C"))