import java.util.Scanner;

class Console {
    private String id;
    private Logic logic;
    
    Console(String id, Logic logic) {
        this.id = id;
        this.logic = logic;
    }

    void start() {
        Scanner sc = new Scanner(System.in);
        String command;
        do {
            System.out.print("Enter a command: ");
            command = sc.next();
            logic.invoke(command, this);
        } while (!command.equals("exit"));
    }

    void feedback(String mesg) {
        System.out.println(id + ": " + mesg);
    }
}