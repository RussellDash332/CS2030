class Student {
    private int labID;
    private String tutID;

    Student(int labID, String tutID) {
        this.labID = labID;
        this.tutID = tutID;
    }

    public int getLabID() {
        return this.labID;
    }

    public String getTutID() {
        return this.tutID;
    }

    @Override
    public String toString() {
        return labID + " : " + tutID;
    }
}    