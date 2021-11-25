class Main2 {
    public static void main(String[] args) {
        Console console = new Console("primary");
        Console console2 = new Console("secondary");
        Logic logic = new Logic(new Console[]{console, console2});
        
        // Expected is console.start() perhaps
        logic.start();
    }
}