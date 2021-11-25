class TFQ extends QA {
    public TFQ(String question) {
        super(question, new char[] {'T', 'F'});
    }

    void getAnswer(){
        super.getAnswer(new InvalidTFQException("Invalid TFQ answer"));
    }
}    