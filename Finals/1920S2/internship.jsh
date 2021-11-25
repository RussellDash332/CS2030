/open Resume.java
/open Internship.java

Internship findInternship(List<String> list) {
    return new Internship("Found");
}

Optional<Internship> match(Resume r) {
    return Optional.ofNullable(r).flatMap(x -> x.getListOfLanguages()).filter(x -> x.contains("Java")).map(x -> findInternship(x));
}