class MCQ extends QA {
    public MCQ(String question) {
        super(question, new char[] {'A', 'B', 'C', 'D', 'E'});
    }

    void getAnswer() {
        super.getAnswer(new InvalidMCQException("Invalid MCQ answer"));
    }
}