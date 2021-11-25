import java.util.Scanner;

class Logic {
    private final Console[] consoles;

    Logic(Console[] consoles) {
        this.consoles = consoles;
    }

    static void invoke(String command, Console console) {
        // do something based on the command
        console.feedback(command + " executed");
    }

    void start() {
        Scanner sc = new Scanner(System.in);
        String command;
        do {
            System.out.print("Enter a command: ");
            command = sc.next();
            for (Console c : consoles) {
                invoke(command, c);
            }
        } while (!command.equals("exit"));
    }
}