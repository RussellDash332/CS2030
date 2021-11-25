import java.util.Arrays;
import java.util.Scanner;

class QA {
    private final String question;
    private final char[] answers;
    private char ans;

    QA(String question, char[] answers) {
        this.question = question;
        this.answers = answers;
    }

    void getAnswer(InvalidQException ex) throws InvalidQException{
        System.out.print(question + " ");
        ans = (new Scanner(System.in)).next().charAt(0);
        for (char answer : answers) {
            if (answer == ans) {
                return;
            }
        }
        throw ex;
    }
}
