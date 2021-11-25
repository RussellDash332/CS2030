class Main {
    public static void main(String[] args) {
        try {
            MCQ mcq = new MCQ("What is the answer to this MCQ?");
            TFQ tfq = new TFQ("What is the answer to this TFQ?");
            mcq.getAnswer();
            tfq.getAnswer();
        } catch (InvalidQException ex) {
            System.err.println(ex);
        }
    }
}