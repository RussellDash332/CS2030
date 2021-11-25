class Console {
    private String id;
    
    Console(String id) {
        this.id = id;
    }

    void feedback(String mesg) {
        System.out.println(id + ": " + mesg);
    }
}