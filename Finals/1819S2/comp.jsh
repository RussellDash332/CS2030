/open Student.java

Comparator<Student> comp1 = (x,y) -> x.getLabID() - y.getLabID();
Comparator<Student> comp2 = (x,y) -> x.getTutID().compareTo(y.getTutID());
List<Comparator<Student>> comparatorList = List.<Comparator<Student>>of(comp1, comp2);

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        for (Comparator<Student> comp : comparatorList) {
            if (comp.compare(s1, s2) != 0) {
                return comp.compare(s1, s2);
            }
        }
        return 0;
    }
}

List<Student> stus = new ArrayList<Student>();
for (Student stu : List.<Student>of(new Student(1, "a2"), new Student(3, "b1"), new Student(3, "a2"), new Student(1, "b1"))) {
    stus.add(stu);
}
stus.sort(new StudentComparator());
System.out.println(stus);